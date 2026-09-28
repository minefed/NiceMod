package ru.miuno.blocks.decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import ru.miuno.blocks.ShapeCache;

public class Weathercock extends LightningRodBlock {
	private static final ShapeCache OUTLINE_SHAPES = new ShapeCache(Weathercock::createOutlineShape);

	public Weathercock(Settings settings) {
		super(settings);
	}

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView view, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPES.get(blockState);
    }

    private static VoxelShape createOutlineShape(BlockState blockState) {
        Direction dir = blockState.get(FACING);
        return switch (dir) {
            case UP -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
            case DOWN -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 0.75);
            case NORTH -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 1, 1);
            case SOUTH -> VoxelShapes.cuboid(0.25, 0, 0, 0.75, 1, 0.75);
            case EAST -> VoxelShapes.cuboid(0, 0, 0.25, 0.75, 1, 0.75);
            case WEST -> VoxelShapes.cuboid(0.25, 0, 0.25, 1, 1, 0.75);
        };
    }
}
