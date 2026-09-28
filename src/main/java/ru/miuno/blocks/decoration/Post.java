package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.WaterloggableBlock;
import ru.miuno.blocks.ShapeCache;

public class Post extends WaterloggableBlock {
    private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(Post::createOutlineShape);

    public Post(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPES.get(state);
    }

    private static VoxelShape createOutlineShape(BlockState state) {
        return Block.createCuboidShape(5, 0, 5, 11, 16, 11);
    }
}