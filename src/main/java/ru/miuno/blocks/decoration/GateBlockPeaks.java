package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.HorizontalHalf;
import ru.miuno.blocks.ShapeCache;

public class GateBlockPeaks extends HorizontalHalf {
    private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(GateBlockPeaks::createOutlineShape);

    public GateBlockPeaks(Settings settings) {
        super(settings);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPES.get(state);
    }

    private static VoxelShape createOutlineShape(BlockState state) {
        Direction dir = state.get(FACING);
        if (state.get(HALF) == BlockHalf.BOTTOM) {
			return switch (dir) {
				case NORTH -> Block.createCuboidShape(0, 0, 6, 16, 14, 10);
				case SOUTH -> Block.createCuboidShape(0, 0, 6, 16, 14, 10);
				case EAST -> Block.createCuboidShape(6, 0, 0, 10, 14, 16);
				case WEST -> Block.createCuboidShape(6, 0, 0, 10, 14, 16);
				default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			};
        } else {
			return switch (dir) {
				case NORTH -> Block.createCuboidShape(0, 2, 6, 16, 16, 10);
				case SOUTH -> Block.createCuboidShape(0, 2, 6, 16, 16, 10);
				case EAST -> Block.createCuboidShape(6, 2, 0, 10, 16, 16);
				case WEST -> Block.createCuboidShape(6, 2, 0, 10, 16, 16);
				default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
			};
        }
    }
}