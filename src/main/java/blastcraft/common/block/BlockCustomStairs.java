package blastcraft.common.block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlockCustomStairs extends StairBlock {

	public BlockCustomStairs(BlockState state, float hardness, float resistance) {
		super(state, Blocks.IRON_BLOCK.properties().requiresCorrectToolForDrops().strength(hardness, resistance));
	}

}
