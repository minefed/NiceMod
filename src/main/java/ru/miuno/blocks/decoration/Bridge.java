package ru.miuno.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.block_types.Horizontal;
import ru.miuno.blocks.ShapeCache;

public class Bridge extends Horizontal{
    private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(Bridge::createOutlineShape);

    public Bridge(Settings settings) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
		return OUTLINE_SHAPES.get(state);
	}

	private static VoxelShape createOutlineShape(BlockState state) {
		Direction dir = state.get(FACING);
		switch(dir) {
			case NORTH:
				return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
			case SOUTH:
				return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
			case EAST:
				return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
			case WEST:
				return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
			default:
				return VoxelShapes.fullCube();
		}
	}
}
