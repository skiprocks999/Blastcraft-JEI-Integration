package blastcraft.common.block;

import blastcraft.common.tile.TileCamoflauge;
import blastcraft.registers.BlastcraftBlocks;
import com.mojang.serialization.MapCodec;
import electrodynamics.prefab.block.GenericEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockCamoflage extends GenericEntityBlock {

    public BlockCamoflage() {
        super(Blocks.WHITE_WOOL.properties().strength(0.3f, 1.0f).sound(SoundType.WOOL).isRedstoneConductor((a, b, c) -> false).noOcclusion());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(BlastcraftBlockStates.HASCAMOFLAUGE, false).setValue(BlastcraftBlockStates.ISWALKTHROUGHABLE, false);
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(this) || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return state.getValue(BlastcraftBlockStates.ISWALKTHROUGHABLE) ? Shapes.empty() : super.getShape(state, worldIn, pos, context);
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        if (!state.getValue(BlastcraftBlockStates.HASCAMOFLAUGE)) {
            return false;
        }

        if (level.getBlockEntity(pos) instanceof TileCamoflauge camo) {
            if (camo.isCamoAir()) {
                return false;
            }
            return camo.getCamoBlock().propagatesSkylightDown(level, pos);
        }

        return false;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (stack.isEmpty()) {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }

        // require block in hand and camo block
        if (!(stack.getItem() instanceof BlockItem blockItem) || !(level.getBlockEntity(pos) instanceof TileCamoflauge camo)) {

            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

        }
        Block block = blockItem.getBlock();

        if (block == BlastcraftBlocks.BLOCK_CAMOFLAGE.get()) {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }

        BlockPlaceContext newCtx = new BlockPlaceContext(player, hand, stack, hitResult);

        if (state.getValue(BlastcraftBlockStates.HASCAMOFLAUGE)) {

            if (camo.getCamoBlock().is(block)) {
                return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
            }
            if (!level.isClientSide) {
                camo.setCamoBlock(block.getStateForPlacement(newCtx));
                level.playSound(null, pos, block.defaultBlockState().getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                level.getChunkSource().getLightEngine().checkBlock(pos);
            }
            return ItemInteractionResult.CONSUME;
        }
        if (!level.isClientSide) {
            state = state.setValue(BlastcraftBlockStates.HASCAMOFLAUGE, true);
            camo.setCamoBlock(block.getStateForPlacement(newCtx));
            level.playSound(null, pos, block.defaultBlockState().getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlockAndUpdate(pos, state);
            level.getChunkSource().getLightEngine().checkBlock(pos);
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BlastcraftBlockStates.HASCAMOFLAUGE, BlastcraftBlockStates.ISWALKTHROUGHABLE);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return state.getValue(BlastcraftBlockStates.HASCAMOFLAUGE) ? RenderShape.INVISIBLE : super.getRenderShape(state);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileCamoflauge(pos, state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        if (state.getValue(BlastcraftBlockStates.ISWALKTHROUGHABLE) || pathComputationType == PathComputationType.WATER) {
            return false;
        }
        return super.isPathfindable(state, pathComputationType);
    }

    @Override
    public void onPickup(ItemStack stack, BlockPos pos, Player player) {

        Level world = player.level();
        BlockState state = world.getBlockState(pos);

        if (world.getBlockEntity(pos) instanceof TileCamoflauge camo) {
            camo.setCamoBlock(Blocks.AIR.defaultBlockState());
        }

        player.level().setBlockAndUpdate(pos, state.setValue(BlastcraftBlockStates.HASCAMOFLAUGE, false));
    }

    @Override
    public void onRotate(ItemStack stack, BlockPos pos, Player player) {

        Level world = player.level();
        BlockState state = world.getBlockState(pos);

        world.setBlockAndUpdate(pos, state.setValue(BlastcraftBlockStates.ISWALKTHROUGHABLE, !state.getValue(BlastcraftBlockStates.ISWALKTHROUGHABLE)));

    }
}
