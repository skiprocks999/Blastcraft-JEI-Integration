package blastcraft.common.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;

public class BlockCustomWall extends WallBlock {

	public BlockCustomWall(float resistance, float hardness) {
		super(Blocks.STONE.properties().requiresCorrectToolForDrops().strength(hardness, resistance));
	}

}
