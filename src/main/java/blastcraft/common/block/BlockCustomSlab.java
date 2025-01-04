package blastcraft.common.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;

public class BlockCustomSlab extends SlabBlock {

	public BlockCustomSlab(float resistance, float hardness) {
		super(Blocks.IRON_BLOCK.properties().requiresCorrectToolForDrops().strength(hardness, resistance));
	}

}
