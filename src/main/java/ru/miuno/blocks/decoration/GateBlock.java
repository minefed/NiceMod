package ru.miuno.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;
import ru.miuno.blocks.ShapeCache;

public class GateBlock extends Horizontal {
    private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(GateBlock::createOutlineShape);

    public GateBlock(Settings settings) {
        super(settings);
    }
    
    @Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		return OUTLINE_SHAPES.get(state);
	}

	private static VoxelShape createOutlineShape(BlockState state) {
		Direction dir = state.get(FACING);
		return switch (dir) {
			case NORTH -> Block.createCuboidShape(0, 0, 6, 16, 16, 10);
			case SOUTH -> Block.createCuboidShape(0, 0, 6, 16, 16, 10);
			case EAST -> Block.createCuboidShape(6, 0, 0, 10, 16, 16);
			case WEST -> Block.createCuboidShape(6, 0, 0, 10, 16, 16);
			default -> Block.createCuboidShape(0, 0, 0, 16, 16, 16);
		};
	}
}
