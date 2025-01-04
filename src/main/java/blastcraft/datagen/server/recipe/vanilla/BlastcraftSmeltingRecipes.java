package blastcraft.datagen.server.recipe.vanilla;

import blastcraft.References;
import blastcraft.common.block.subtype.SubtypeBlastproofWall;
import blastcraft.common.block.subtype.SubtypeCarbonPlatedWall;
import blastcraft.common.block.subtype.SubtypeHardenedBricks;
import blastcraft.common.block.subtype.SubtypeRawBlastproofWall;
import blastcraft.registers.BlastcraftItems;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.ElectrodynamicsCookingRecipe;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;

public class BlastcraftSmeltingRecipes extends AbstractRecipeGenerator {

	@Override
	public void addRecipes(RecipeOutput output) {

		ElectrodynamicsCookingRecipe.smeltingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_blastproofwalling_smelting"), References.ID, BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_blastproofwalling_blasting"), References.ID, BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_rawblastproofwalling_smelting"), References.ID, BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_rawblastproofwalling_blasting"), References.ID, BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_carbonplatedwalling_smelting"), References.ID, BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_carbonplatedwalling_blasting"), References.ID, BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.smeltingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_hardenedbricks_smelting"), References.ID, BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 0.1F, 200)
				//
				.input(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
				//
				.save(output);

		ElectrodynamicsCookingRecipe.blastingRecipe(ResourceLocation.fromNamespaceAndPath(References.ID, "smooth_hardenedbricks_blasting"), References.ID, BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 0.1F, 100)
				//
				.input(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
				//
				.save(output);

	}

}
