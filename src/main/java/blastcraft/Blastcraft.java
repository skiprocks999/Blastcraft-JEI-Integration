package blastcraft;

import blastcraft.client.ClientRegister;
import blastcraft.common.block.BlastcraftBlockStates;
import blastcraft.common.settings.Constants;
import blastcraft.common.tag.BlastcraftTags;
import blastcraft.registers.UnifiedBlastcraftRegister;
import electrodynamics.prefab.configuration.ConfigurationHandler;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod(References.ID)
@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD)
public class Blastcraft {

	public Blastcraft(IEventBus bus) {
		ConfigurationHandler.registerConfig(Constants.class);
		BlastcraftBlockStates.init();
		UnifiedBlastcraftRegister.register(bus);
	}

	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		BlastcraftTags.init();
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ClientRegister.setup();
		});
	}

	@SubscribeEvent
	public static void onLoadEvent(FMLLoadCompleteEvent event) {
	}

	public static final ResourceLocation rl(String path) {
		return ResourceLocation.fromNamespaceAndPath(References.ID, path);
	}
}
