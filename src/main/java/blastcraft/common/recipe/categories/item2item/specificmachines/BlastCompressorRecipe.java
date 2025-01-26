package blastcraft.common.recipe.categories.item2item.specificmachines;

import blastcraft.Blastcraft;
import blastcraft.common.recipe.BlastCraftRecipeInit;
import electrodynamics.common.recipe.categories.item2item.Item2ItemRecipe;
import electrodynamics.common.recipe.recipeutils.CountableIngredient;
import electrodynamics.common.recipe.recipeutils.ProbableFluid;
import electrodynamics.common.recipe.recipeutils.ProbableGas;
import electrodynamics.common.recipe.recipeutils.ProbableItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public class BlastCompressorRecipe extends Item2ItemRecipe {

	public static final String RECIPE_GROUP = "blast_compressor_recipe";
	public static final ResourceLocation RECIPE_ID = Blastcraft.rl(RECIPE_GROUP);

	public BlastCompressorRecipe(String group, List<CountableIngredient> inputs, ItemStack output, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
		super(group, inputs, output, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return BlastCraftRecipeInit.BLAST_COMPRESSOR_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return BlastCraftRecipeInit.BLAST_COMPRESSOR_TYPE.get();
	}

}
