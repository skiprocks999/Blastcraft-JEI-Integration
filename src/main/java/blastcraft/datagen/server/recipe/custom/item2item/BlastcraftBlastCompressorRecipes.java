package blastcraft.datagen.server.recipe.custom.item2item;

import blastcraft.References;
import blastcraft.common.block.subtype.SubtypeBlastproofWall;
import blastcraft.common.recipe.categories.item2item.specificmachines.BlastCompressorRecipe;
import blastcraft.common.tag.BlastcraftTags;
import blastcraft.registers.BlastcraftItems;
import electrodynamics.common.recipe.recipeutils.ProbableItem;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.builders.ElectrodynamicsRecipeBuilder;
import electrodynamics.datagen.utils.recipe.builders.Item2ItemBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BlastcraftBlastCompressorRecipes extends AbstractRecipeGenerator {

    public static double BLASTCOMPRESSOR_USAGE_PER_TICK = 100.0;
    public static int BLASTCOMPRESSOR_REQUIRED_TICKS = 220;

    private final String modID;

    public BlastcraftBlastCompressorRecipes(String modID) {
        this.modID = modID;
    }

    public BlastcraftBlastCompressorRecipes() {
        this(References.ID);
    }

    @Override
    public void addRecipes(RecipeOutput output) {

        newRecipe(new ItemStack(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base)), 0.1F, 220, 100, "blastproofwalling", modID)
                //
                .addItemTagInput(BlastcraftTags.Items.SOLID_RAW_BLASTPROOF_WALLS, 1)
                //
                .addItemBiproduct(new ProbableItem(new ItemStack(Items.GUNPOWDER), 0.3))
                //
                .save(output);

    }

    public Item2ItemBuilder<BlastCompressorRecipe> newRecipe(ItemStack stack, float xp, int ticks, double usagePerTick, String name, String group) {
        return new Item2ItemBuilder<>(BlastCompressorRecipe::new, stack, ElectrodynamicsRecipeBuilder.RecipeCategory.ITEM_2_ITEM, modID, "blast_compressor/" + name, group, xp, ticks, usagePerTick);
    }

}
