package blastcraft.common.tile;

import blastcraft.registers.BlastcraftTiles;
import electrodynamics.prefab.properties.Property;
import electrodynamics.prefab.properties.PropertyTypes;
import electrodynamics.prefab.tile.GenericTile;
import electrodynamics.prefab.tile.components.type.ComponentPacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TileCamoflauge extends GenericTile {

	public final Property<BlockState> camoflaugedBlock = property(new Property<>(PropertyTypes.BLOCK_STATE, "camoblock", Blocks.AIR.defaultBlockState()).onChange((prop, oldState) -> {
		if(level == null) {
			return;
		}
		level.getChunkSource().getLightEngine().checkBlock(worldPosition);
	}).setShouldUpdateOnChange());

	public TileCamoflauge(BlockPos worldPosition, BlockState blockState) {
		super(BlastcraftTiles.TILE_CAMOFLAGE.get(), worldPosition, blockState);
		addComponent(new ComponentPacketHandler(this));
	}

	public void setCamoBlock(BlockState block) {
		camoflaugedBlock.set(block);
		setChanged();
	}

	public BlockState getCamoBlock() {
		return camoflaugedBlock.get();
	}

	public boolean isCamoAir() {
		return getCamoBlock().isAir();
	}

	@Override
	public InteractionResult useWithoutItem(Player player, BlockHitResult hit) {
		return InteractionResult.PASS;
	}

	@Override
	public ItemInteractionResult useWithItem(ItemStack used, Player player, InteractionHand hand, BlockHitResult hit) {
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
}
