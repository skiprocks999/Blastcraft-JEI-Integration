package blastcraft.client.guidebook;

import blastcraft.Blastcraft;
import blastcraft.References;
import blastcraft.client.guidebook.chapters.ChapterBlocks;
import blastcraft.prefab.utils.BlastcraftTextUtils;
import electrodynamics.client.guidebook.utils.components.Module;
import electrodynamics.client.guidebook.utils.pagedata.graphics.ImageWrapperObject;
import net.minecraft.network.chat.MutableComponent;

public class ModuleBlastcraft extends Module {

	private static final ImageWrapperObject LOGO = new ImageWrapperObject(0, 0, 0, 0, 32, 32, 32, 32, Blastcraft.rl("textures/screen/guidebook/blastcraftlogo.png"));

	@Override
	public ImageWrapperObject getLogo() {
		return LOGO;
	}

	@Override
	public MutableComponent getTitle() {
		return BlastcraftTextUtils.guidebook(References.ID);
	}

	@Override
	public void addChapters() {
		chapters.add(new ChapterBlocks(this));
	}

}
