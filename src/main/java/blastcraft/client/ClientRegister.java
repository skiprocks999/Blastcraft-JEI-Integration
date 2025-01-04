package blastcraft.client;

import blastcraft.References;
import blastcraft.client.guidebook.ModuleBlastcraft;
import blastcraft.client.render.tile.RenderCamoflage;
import blastcraft.registers.BlastcraftFluids;
import blastcraft.registers.BlastcraftTiles;
import electrodynamics.client.guidebook.ScreenGuidebook;
import electrodynamics.client.misc.SWBFClientExtensions;
import electrodynamics.common.fluid.SimpleWaterBasedFluidType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class ClientRegister {

	public static void setup() {
		ScreenGuidebook.addGuidebookModule(new ModuleBlastcraft());
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerEntities(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BlastcraftTiles.TILE_CAMOFLAGE.get(), RenderCamoflage::new);

	}

	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event) {

		BlastcraftFluids.FLUIDS.getEntries().forEach((fluid) -> {
			event.registerFluidType(new SWBFClientExtensions((SimpleWaterBasedFluidType) fluid.get().getFluidType()), fluid.get().getFluidType());
		});

	}

}
