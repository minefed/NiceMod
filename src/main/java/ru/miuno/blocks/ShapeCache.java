package ru.miuno.blocks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

// Caches a shape that depends only on the block state: the original computation runs once per state
// and later lookups return its result. Safe to use from chunk builder worker threads.
public final class ShapeCache {
    private final Map<BlockState, VoxelShape> shapes = new ConcurrentHashMap<>();
    private final Function<BlockState, VoxelShape> factory;

    public ShapeCache(Function<BlockState, VoxelShape> factory) {
        this.factory = factory;
    }

    public VoxelShape get(BlockState state) {
        VoxelShape shape = shapes.get(state);
        return shape != null ? shape : shapes.computeIfAbsent(state, factory);
    }
}
