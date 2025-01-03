package blastcraft.registers;

import blastcraft.common.recipe.BlastCraftRecipeInit;
import electrodynamics.common.blockitem.types.BlockItemDescriptable;
import electrodynamics.prefab.utilities.ElectroTextUtils;
import net.neoforged.bus.api.IEventBus;

public class UnifiedBlastcraftRegister {

	public static void register(IEventBus bus) {
		BlastcraftBlocks.BLOCKS.register(bus);
		BlastcraftFluids.FLUIDS.register(bus);
		BlastcraftFluidTypes.FLUID_TYPES.register(bus);
		BlastcraftItems.ITEMS.register(bus);
		BlastcraftTiles.BLOCK_ENTITY_TYPES.register(bus);
		BlastcraftSounds.SOUNDS.register(bus);
		BlastcraftCreativeTabs.CREATIVE_TABS.register(bus);
		BlastCraftRecipeInit.RECIPE_TYPES.register(bus);
		BlastCraftRecipeInit.RECIPE_SERIALIZER.register(bus);
	}

	static {
		BlockItemDescriptable.addDescription(BlastcraftBlocks.BLOCK_BLASTCOMPRESSOR, ElectroTextUtils.voltageTooltip(240));
	}

}
