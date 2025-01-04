package blastcraft.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockCustomBricks extends Block {

	public BlockCustomBricks(float hardness, float resistance) {
		super(Blocks.IRON_BLOCK.properties().requiresCorrectToolForDrops().strength(hardness, resistance));
	}

}
