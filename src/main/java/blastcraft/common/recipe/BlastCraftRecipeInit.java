package blastcraft.common.recipe;

import blastcraft.References;
import blastcraft.common.recipe.categories.item2item.specificmachines.BlastCompressorRecipe;
import electrodynamics.common.recipe.ElectrodynamicsRecipeInit.CustomRecipeType;
import electrodynamics.common.recipe.categories.item2item.Item2ItemRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlastCraftRecipeInit {

	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, blastcraft.References.ID);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, References.ID);

	/* RECIPE TYPES */

	// ITEM2ITEM
	public static final DeferredHolder<RecipeType<?>, RecipeType<BlastCompressorRecipe>> BLAST_COMPRESSOR_TYPE = RECIPE_TYPES.register(BlastCompressorRecipe.RECIPE_GROUP, CustomRecipeType::new);

	/* RECIPE SERIALIZERS */

	// O2O
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> BLAST_COMPRESSOR_SERIALIZER = RECIPE_SERIALIZER.register(BlastCompressorRecipe.RECIPE_GROUP, () -> new Item2ItemRecipeSerializer<>(BlastCompressorRecipe::new));
}
