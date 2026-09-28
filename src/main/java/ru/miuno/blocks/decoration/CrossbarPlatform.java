package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.WaterloggableBlock;
import ru.miuno.blocks.ShapeCache;

public class CrossbarPlatform extends WaterloggableBlock {
    private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(CrossbarPlatform::createOutlineShape);

    public CrossbarPlatform(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPES.get(state);
    }

    private static VoxelShape createOutlineShape(BlockState state) {
        return VoxelShapes.union(Block.createCuboidShape(4, 0, 4, 12, 16, 12), Block.createCuboidShape(0, 13, 0, 16, 16, 16));
    }
}
