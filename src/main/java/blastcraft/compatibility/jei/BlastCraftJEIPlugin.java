package blastcraft.compatibility.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import blastcraft.Blastcraft;
import blastcraft.common.recipe.BlastCraftRecipeInit;
import blastcraft.common.recipe.categories.item2item.specificmachines.BlastCompressorRecipe;
import blastcraft.compatibility.jei.recipecategories.item2item.specificmachines.BlastCompressorRecipeCategory;
import blastcraft.registers.BlastcraftFluids;
import electrodynamics.client.screen.tile.ScreenO2OProcessor;
import electrodynamics.compatibility.jei.ElectrodynamicsJEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;

@JeiPlugin
public class BlastCraftJEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = Blastcraft.rl("jei");
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(BlastCompressorRecipeCategory.INPUT_MACHINE, BlastCompressorRecipeCategory.RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        ClientLevel world = Objects.requireNonNull(mc.level);
        RecipeManager recipeManager = world.getRecipeManager();

        // Blast Compressor
        List<BlastCompressorRecipe> blastCompressorRecipes = recipeManager.getAllRecipesFor(BlastCraftRecipeInit.BLAST_COMPRESSOR_TYPE.get()).stream().map(val -> val.value()).toList();
        registration.addRecipes(BlastCompressorRecipeCategory.RECIPE_TYPE, blastCompressorRecipes);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BlastCompressorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        registry.addRecipeClickArea(ScreenO2OProcessor.class, 48, 35, 22, 15, ElectrodynamicsJEIPlugin.O2O_CLICK_AREAS.toArray(new mezz.jei.api.recipe.RecipeType[ElectrodynamicsJEIPlugin.O2O_CLICK_AREAS.size()]));
    }

    @Override
    public void registerExtraIngredients(IExtraIngredientRegistration registration) {
        List<FluidStack> fluids = new ArrayList<>();
        for (DeferredHolder<Fluid, ? extends Fluid> fluid : BlastcraftFluids.FLUIDS.getEntries()) {
            fluids.add(new FluidStack(fluid.get(), 1000));
        }
        registration.addExtraIngredients(NeoForgeTypes.FLUID_STACK, fluids);
    }

}
