package blastcraft.datagen.server.recipe.vanilla;

import blastcraft.References;
import blastcraft.common.block.subtype.SubtypeBlastproofWall;
import blastcraft.common.block.subtype.SubtypeCarbonPlatedWall;
import blastcraft.common.block.subtype.SubtypeConcrete;
import blastcraft.common.block.subtype.SubtypeHardenedBricks;
import blastcraft.common.block.subtype.SubtypeRawBlastproofWall;
import blastcraft.common.block.subtype.SubtypeWallingGlass;
import blastcraft.common.tag.BlastcraftTags;
import blastcraft.registers.BlastcraftItems;
import electrodynamics.common.tags.ElectrodynamicsTags;
import electrodynamics.datagen.utils.recipe.AbstractRecipeGenerator;
import electrodynamics.datagen.utils.recipe.ShapedCraftingRecipeBuilder;
import electrodynamics.datagen.utils.recipe.ShapelessCraftingRecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;

public class BlastcraftCraftingTableRecipes extends AbstractRecipeGenerator {

    @Override
    public void addRecipes(RecipeOutput output) {

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_CAMOFLAGE.get(), 12)
                //
                .addPattern("WGW")
                //
                .addPattern("GWG")
                //
                .addPattern("WGW")
                //
                .addKey('W', ItemTags.WOOL)
                //
                .addKey('G', Tags.Items.GLASS_BLOCKS)
                //
                .complete(References.ID, "camoflage", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_GLASSPRESSUREPLATE.get(), 1)
                //
                .addPattern("GG")
                //
                .addKey('G', Tags.Items.GLASS_BLOCKS)
                //
                .complete(References.ID, "glass_pressureplate", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_SPIKE.get(), 6)
                //
                .addPattern("CGC")
                //
                .addPattern("PPP")
                //
                .addKey('C', Items.CACTUS)
                //
                .addKey('G', Items.SHORT_GRASS)
                //
                .addKey('P', ElectrodynamicsTags.Items.PLATE_BRONZE)
                //
                .complete(References.ID, "spikes_regular", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEM_FIRESPIKE.get(), 1)
                //
                .addIngredient(BlastcraftItems.ITEM_SPIKE.get())
                //
                .addIngredient(Items.FIRE_CHARGE)
                //
                .complete(References.ID, "spikes_fire", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEM_POISONSPIKE.get(), 1)
                //
                .addIngredient(BlastcraftItems.ITEM_SPIKE.get())
                //
                .addIngredient(Items.SPIDER_EYE)
                //
                .addConditions(new NotCondition(new ModLoadedCondition(References.BALLISTIX_ID)))
                //
                .complete(References.ID, "spikes_poison_spidereye", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEM_POISONSPIKE.get(), 1)
                //
                .addIngredient(BlastcraftItems.ITEM_SPIKE.get())
                //
                .addIngredient(BlastcraftTags.Items.DUST_POISON)
                //
                .addConditions(new ModLoadedCondition(References.BALLISTIX_ID))
                //
                .complete(References.ID, "spikes_poison_poisondust", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_CONCRETEMIX.get(), 4)
                //
                .addPattern("SGS")
                //
                .addPattern("GMG")
                //
                .addPattern("SGS")
                //
                .addKey('S', ItemTags.SAND)
                //
                .addKey('G', Tags.Items.GRAVELS)
                //
                .addKey('M', ElectrodynamicsTags.Items.SLAG)
                //
                .complete(References.ID, "concretemix_slag", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_CONCRETEMIX.get(), 10)
                //
                .addPattern("SGS")
                //
                .addPattern("GMG")
                //
                .addPattern("SGS")
                //
                .addKey('S', ItemTags.SAND)
                //
                .addKey('G', Tags.Items.GRAVELS)
                //
                .addKey('M', ElectrodynamicsTags.Items.DUST_NETHERITE)
                //
                .complete(References.ID, "concretemix_netherite", output);

        addMachines(output);

        addHardenedBricks(output);

        addRawBlastproofWalls(output);

        addBlastproofWalls(output);

        addCarbonPlatedWalls(output);

        addConcrete(output);

        // GLASS BRICKS

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_WALLINGGLASS.getValue(SubtypeWallingGlass.blastproofwalling), 1)
                //
                .addIngredient(Tags.Items.GLASS_BLOCKS)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_BLASTPROOF_WALLS)
                //
                .complete(References.ID, "glass_blastproofwalling", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_WALLINGGLASS.getValue(SubtypeWallingGlass.rawblastproofwalling), 1)
                //
                .addIngredient(Tags.Items.GLASS_BLOCKS)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_RAW_BLASTPROOF_WALLS)
                //
                .complete(References.ID, "glass_rawblastproofwalling", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_WALLINGGLASS.getValue(SubtypeWallingGlass.carbonplatedwalling), 1)
                //
                .addIngredient(Tags.Items.GLASS_BLOCKS)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_CARBON_PLATED_WALLS)
                //
                .complete(References.ID, "glass_carbonplatedwalling", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_WALLINGGLASS.getValue(SubtypeWallingGlass.hardenedbricks), 1)
                //
                .addIngredient(Tags.Items.GLASS_BLOCKS)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_HARDENED_BRICKS)
                //
                .complete(References.ID, "glass_hardenedbricks", output);

    }

    private void addMachines(RecipeOutput output) {

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEM_BLASTCOMPRESSOR.get(), 1)
                //
                .addPattern("SFS")
                //
                .addPattern("PCP")
                //
                .addPattern("SSS")
                //
                .addKey('S', ElectrodynamicsTags.Items.PLATE_STEEL)
                //
                .addKey('F', Items.FURNACE)
                //
                .addKey('P', Items.PISTON)
                //
                .addKey('C', ElectrodynamicsTags.Items.CIRCUITS_ADVANCED)
                //
                .complete(References.ID, "blastcompressor", output);

    }

    private void addHardenedBricks(RecipeOutput output) {

        // BASE BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 6)
                //
                .addPattern("OBO")
                //
                .addPattern("OBO")
                //
                .addPattern("OBO")
                //
                .addKey('O', Tags.Items.OBSIDIANS)
                //
                .addKey('B', Items.BRICKS)
                //
                .complete(References.ID, "base_hardenedbricks_obsidian", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 6)
                //
                .addPattern("CBC")
                //
                .addPattern("CBC")
                //
                .addPattern("CBC")
                //
                .addKey('C', BlastcraftTags.Items.SOLID_CONCRETES)
                //
                .addKey('B', Items.BRICKS)
                //
                .complete(References.ID, "base_hardenedbricks_concrete", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
                //
                .complete(References.ID, "base_hardenedbricks_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_stairs))
                //
                .complete(References.ID, "base_hardenedbricks_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
                //
                .complete(References.ID, "base_hardenedbricks_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_wall))
                //
                .complete(References.ID, "base_hardenedbricks_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base))
                //
                .complete(References.ID, "base_hardenedbricks_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base_slab))
                //
                .complete(References.ID, "base_hardenedbricks_slabreset", output);

        // BIG BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base)))
                //
                .complete(References.ID, "big_hardenedbricks", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big))
                //
                .complete(References.ID, "big_hardenedbricks_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_stairs))
                //
                .complete(References.ID, "big_hardenedbricks_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big))
                //
                .complete(References.ID, "big_hardenedbricks_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_wall))
                //
                .complete(References.ID, "big_hardenedbricks_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big))
                //
                .complete(References.ID, "big_hardenedbricks_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.big_slab))
                //
                .complete(References.ID, "big_hardenedbricks_slabreset", output);

        // SMOOTH

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth))
                //
                .complete(References.ID, "smooth_hardenedbricks_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_stairs))
                //
                .complete(References.ID, "smooth_hardenedbricks_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth))
                //
                .complete(References.ID, "smooth_hardenedbricks_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_wall))
                //
                .complete(References.ID, "smooth_hardenedbricks_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth))
                //
                .complete(References.ID, "smooth_hardenedbricks_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth_slab))
                //
                .complete(References.ID, "smooth_hardenedbricks_slabreset", output);

        // POLISHED BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.smooth)))
                //
                .complete(References.ID, "polished_hardenedbricks", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished))
                //
                .complete(References.ID, "polished_hardenedbricks_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_stairs))
                //
                .complete(References.ID, "polished_hardenedbricks_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished))
                //
                .complete(References.ID, "polished_hardenedbricks_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_wall))
                //
                .complete(References.ID, "polished_hardenedbricks_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished))
                //
                .complete(References.ID, "polished_hardenedbricks_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.polished_slab))
                //
                .complete(References.ID, "polished_hardenedbricks_slabreset", output);

        // RESET BRICKS

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_HARDENEDBRICKS.getValue(SubtypeHardenedBricks.base), 1)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_HARDENED_BRICKS)
                //
                .complete(References.ID, "reset_hardenedbricks", output);

    }

    private void addRawBlastproofWalls(RecipeOutput output) {

        // BASE BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 3)
                //
                .addPattern("OHO")
                //
                .addPattern("OHO")
                //
                .addPattern("OHO")
                //
                .addKey('H', BlastcraftTags.Items.SOLID_HARDENED_BRICKS)
                //
                .addKey('O', Tags.Items.OBSIDIANS)
                //
                .complete(References.ID, "base_rawblastproofwalling_obsidian", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 3)
                //
                .addPattern("CHC")
                //
                .addPattern("CHC")
                //
                .addPattern("CHC")
                //
                .addKey('H', BlastcraftTags.Items.SOLID_HARDENED_BRICKS)
                //
                .addKey('C', BlastcraftTags.Items.SOLID_CONCRETES)
                //
                .complete(References.ID, "base_rawblastproofwalling_concrete", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
                //
                .complete(References.ID, "base_rawblastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_stairs))
                //
                .complete(References.ID, "base_rawblastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
                //
                .complete(References.ID, "base_rawblastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_wall))
                //
                .complete(References.ID, "base_rawblastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base))
                //
                .complete(References.ID, "base_rawblastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base_slab))
                //
                .complete(References.ID, "base_rawblastproofwall_slabreset", output);

        // BIG BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base)))
                //
                .complete(References.ID, "big_rawblastproofwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big))
                //
                .complete(References.ID, "big_rawblastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_stairs))
                //
                .complete(References.ID, "big_rawblastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big))
                //
                .complete(References.ID, "big_rawblastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_wall))
                //
                .complete(References.ID, "big_rawblastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big))
                //
                .complete(References.ID, "big_rawblastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.big_slab))
                //
                .complete(References.ID, "big_rawblastproofwall_slabreset", output);

        // SMOOTH

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_rawblastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_stairs))
                //
                .complete(References.ID, "smooth_rawblastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_rawblastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_wall))
                //
                .complete(References.ID, "smooth_rawblastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_rawblastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth_slab))
                //
                .complete(References.ID, "smooth_rawblastproofwall_slabreset", output);

        // POLISHED BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.smooth)))
                //
                .complete(References.ID, "polished_rawblastproofwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished))
                //
                .complete(References.ID, "polished_rawblastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_stairs))
                //
                .complete(References.ID, "polished_rawblastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished))
                //
                .complete(References.ID, "polished_rawblastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_wall))
                //
                .complete(References.ID, "polished_rawblastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished))
                //
                .complete(References.ID, "polished_rawblastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.polished_slab))
                //
                .complete(References.ID, "polished_rawblastproofwall_slabreset", output);

        // RESET BRICKS

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_RAW_BLASTPROOFWALL.getValue(SubtypeRawBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_RAW_BLASTPROOF_WALLS)
                //
                .complete(References.ID, "reset_rawblastproofwalling", output);

    }

    private void addBlastproofWalls(RecipeOutput output) {

        // BASE BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
                //
                .complete(References.ID, "base_blastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_stairs))
                //
                .complete(References.ID, "base_blastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
                //
                .complete(References.ID, "base_blastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_wall))
                //
                .complete(References.ID, "base_blastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base))
                //
                .complete(References.ID, "base_blastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base_slab))
                //
                .complete(References.ID, "base_blastproofwall_slabreset", output);

        // BIG BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base)))
                //
                .complete(References.ID, "big_blastproofwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big))
                //
                .complete(References.ID, "big_blastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_stairs))
                //
                .complete(References.ID, "big_blastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big))
                //
                .complete(References.ID, "big_blastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_wall))
                //
                .complete(References.ID, "big_blastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big))
                //
                .complete(References.ID, "big_blastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.big_slab))
                //
                .complete(References.ID, "big_blastproofwall_slabreset", output);

        // SMOOTH

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_blastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_stairs))
                //
                .complete(References.ID, "smooth_blastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_blastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_wall))
                //
                .complete(References.ID, "smooth_blastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth))
                //
                .complete(References.ID, "smooth_blastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth_slab))
                //
                .complete(References.ID, "smooth_blastproofwall_slabreset", output);

        // POLISHED BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.smooth)))
                //
                .complete(References.ID, "polished_blastproofwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished))
                //
                .complete(References.ID, "polished_blastproofwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_stairs))
                //
                .complete(References.ID, "polished_blastproofwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished))
                //
                .complete(References.ID, "polished_blastproofwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_wall))
                //
                .complete(References.ID, "polished_blastproofwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished))
                //
                .complete(References.ID, "polished_blastproofwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.polished_slab))
                //
                .complete(References.ID, "polished_blastproofwall_slabreset", output);

        // RESET BRICKS

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_BLASTPROOFWALL.getValue(SubtypeBlastproofWall.base), 1)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_BLASTPROOF_WALLS)
                //
                .complete(References.ID, "reset_blastproofwalling", output);

    }

    private void addCarbonPlatedWalls(RecipeOutput output) {

        // BASE BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base), 3)
                //
                .addPattern("CWC")
                //
                .addPattern("CWC")
                //
                .addPattern("CWC")
                //
                .addKey('W', BlastcraftTags.Items.SOLID_BLASTPROOF_WALLS)
                //
                .addKey('C', ItemTags.COALS)
                //
                .complete(References.ID, "base_carbonplatedwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
                //
                .complete(References.ID, "base_carbonplatedwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_stairs))
                //
                .complete(References.ID, "base_carbonplatedwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
                //
                .complete(References.ID, "base_carbonplatedwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_wall))
                //
                .complete(References.ID, "base_carbonplatedwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base))
                //
                .complete(References.ID, "base_carbonplatedwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base_slab))
                //
                .complete(References.ID, "base_carbonplatedwall_slabreset", output);

        // BIG BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base)))
                //
                .complete(References.ID, "big_carbonplatedwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big))
                //
                .complete(References.ID, "big_carbonplatedwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_stairs))
                //
                .complete(References.ID, "big_carbonplatedwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big))
                //
                .complete(References.ID, "big_carbonplatedwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_wall))
                //
                .complete(References.ID, "big_carbonplatedwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big))
                //
                .complete(References.ID, "big_carbonplatedwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.big_slab))
                //
                .complete(References.ID, "big_carbonplatedwall_slabreset", output);

        // SMOOTH

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth))
                //
                .complete(References.ID, "smooth_carbonplatedwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_stairs))
                //
                .complete(References.ID, "smooth_carbonplatedwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth))
                //
                .complete(References.ID, "smooth_carbonplatedwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_wall))
                //
                .complete(References.ID, "smooth_carbonplatedwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth))
                //
                .complete(References.ID, "smooth_carbonplatedwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth_slab))
                //
                .complete(References.ID, "smooth_carbonplatedwall_slabreset", output);

        // POLISHED BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished), 4)
                //
                .addPattern("BB")
                //
                .addPattern("BB")
                //
                .addKey('B', new ItemStack(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.smooth)))
                //
                .complete(References.ID, "polished_carbonplatedwalling", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished))
                //
                .complete(References.ID, "polished_carbonplatedwall_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_stairs))
                //
                .complete(References.ID, "polished_carbonplatedwall_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished))
                //
                .complete(References.ID, "polished_carbonplatedwall_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_wall))
                //
                .complete(References.ID, "polished_carbonplatedwall_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished))
                //
                .complete(References.ID, "polished_carbonplatedwall_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.polished_slab))
                //
                .complete(References.ID, "polished_carbonplatedwall_slabreset", output);

        // RESET BRICKS

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CARBONPLATEDWALL.getValue(SubtypeCarbonPlatedWall.base), 1)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_CARBON_PLATED_WALLS)
                //
                .complete(References.ID, "reset_carbonplatedwalling", output);
    }

    private void addConcrete(RecipeOutput output) {

        // REGULAR

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular))
                //
                .complete(References.ID, "regular_concrete_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_stairs))
                //
                .complete(References.ID, "regular_concrete_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular))
                //
                .complete(References.ID, "regular_concrete_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_wall))
                //
                .complete(References.ID, "regular_concrete_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular))
                //
                .complete(References.ID, "regular_concrete_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular_slab))
                //
                .complete(References.ID, "regular_concrete_slabreset", output);

        // BRICKS

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks), 4)
                //
                .addPattern("CC")
                //
                .addPattern("CC")
                //
                .addKey('C', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular))
                //
                .complete(References.ID, "bricks_concrete", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks))
                //
                .complete(References.ID, "bricks_concrete_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_stairs))
                //
                .complete(References.ID, "bricks_concrete_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks))
                //
                .complete(References.ID, "bricks_concrete_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_wall))
                //
                .complete(References.ID, "bricks_concrete_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks))
                //
                .complete(References.ID, "bricks_concrete_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks_slab))
                //
                .complete(References.ID, "bricks_concrete_slabreset", output);

        // TILE

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile), 4)
                //
                .addPattern("CC")
                //
                .addPattern("CC")
                //
                .addKey('C', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.bricks))
                //
                .complete(References.ID, "tile_concrete", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_stairs), 6)
                //
                .addPattern("B  ")
                //
                .addPattern("BB ")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile))
                //
                .complete(References.ID, "tile_concrete_stairs", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_stairs))
                //
                .complete(References.ID, "tile_concrete_stairsreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_wall), 6)
                //
                .addPattern("BBB")
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile))
                //
                .complete(References.ID, "tile_concrete_wall", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_wall))
                //
                .complete(References.ID, "tile_concrete_wallreset", output);

        ShapedCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_slab), 6)
                //
                .addPattern("BBB")
                //
                .addKey('B', BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile))
                //
                .complete(References.ID, "tile_concrete_slab", output);

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile), 1)
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_slab))
                //
                .addIngredient(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.tile_slab))
                //
                .complete(References.ID, "tile_concrete_slabreset", output);

        // RESET

        ShapelessCraftingRecipeBuilder.start(BlastcraftItems.ITEMS_CONCRETE.getValue(SubtypeConcrete.regular), 1)
                //
                .addIngredient(BlastcraftTags.Items.SOLID_CONCRETES)
                //
                .complete(References.ID, "reset_concrete", output);
    }

}
