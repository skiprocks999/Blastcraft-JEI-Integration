package blastcraft.datagen.server.recipe.vanilla;

import blastcraft.Blastcraft;
import blastcraft.References;
import blastcraft.common.block.subtype.SubtypeBlastproofWall;
import blastcraft.common.block.subtype.SubtypeCarbonPlatedWall;
import blastcraft.common.block.subtype.SubtypeHardenedBricks;
import blastcraft.common.block.subtype.SubtypeRawBlastproofWall;
import blastcraft.registers.BlastcraftItems;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.ElectrodynamicsCookingRecipe;
import net.minecraft.data.recipes.RecipeOutput;

public class BlastcraftSmeltingRecipes extends AbstractRecipeGenerator {

	@Override
	public void addRecipes(RecipeOutput output) {

		ElectrodynamicsCookingRecipe.smeltingRecipe(Blastcraft.rl("smooth_blastproofwalling_smelting"), References.ID, BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(Blastcraft.rl("smooth_blastproofwalling_blasting"), References.ID, BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(Blastcraft.rl("smooth_rawblastproofwalling_smelting"), References.ID, BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(Blastcraft.rl("smooth_rawblastproofwalling_blasting"), References.ID, BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(Blastcraft.rl("smooth_carbonplatedwalling_smelting"), References.ID, BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(Blastcraft.rl("smooth_carbonplatedwalling_blasting"), References.ID, BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(Blastcraft.rl("smooth_hardenedbricks_smelting"), References.ID, BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(Blastcraft.rl("smooth_hardenedbricks_blasting"), References.ID, BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
				//
				.save(output);

	}

}
