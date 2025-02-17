package blastcraft.common.tile;

import blastcraft.common.recipe.BlastCraftRecipeInit;
import blastcraft.registers.BlastcraftSounds;
import blastcraft.registers.BlastcraftTiles;
import electrodynamics.common.inventory.container.tile.ContainerO2OProcessor;
import electrodynamics.prefab.sound.SoundBarrierMethods;
import electrodynamics.prefab.sound.utils.ITickableSound;
import electrodynamics.prefab.tile.GenericTile;
import electrodynamics.prefab.tile.components.IComponentType;
import electrodynamics.prefab.tile.components.type.ComponentContainerProvider;
import electrodynamics.prefab.tile.components.type.ComponentElectrodynamic;
import electrodynamics.prefab.tile.components.type.ComponentInventory;
import electrodynamics.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import electrodynamics.prefab.tile.components.type.ComponentPacketHandler;
import electrodynamics.prefab.tile.components.type.ComponentProcessor;
import electrodynamics.prefab.tile.components.type.ComponentTickable;
import electrodynamics.prefab.utilities.BlockEntityUtils;
import electrodynamics.registers.ElectrodynamicsCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.BlockState;

public class TileBlastCompressor extends GenericTile implements ITickableSound {

    private boolean isPlaying = false;

    public TileBlastCompressor(BlockPos worldPosition, BlockState blockState) {
        super(BlastcraftTiles.TILE_BLASTCOMPRESSOR.get(), worldPosition, blockState);
        addComponent(new ComponentPacketHandler(this));
        addComponent(new ComponentTickable(this).tickClient(this::tickClient));
        addComponent(new ComponentElectrodynamic(this, false, true).voltage(ElectrodynamicsCapabilities.DEFAULT_VOLTAGE * 2).setInputDirections(BlockEntityUtils.MachineDirection.BACK));
        addComponent(new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 1, 1, 1).upgrades(3))
                //
                .setDirectionsBySlot(0, BlockEntityUtils.MachineDirection.TOP, BlockEntityUtils.MachineDirection.RIGHT)
                //
                .setDirectionsBySlot(1, BlockEntityUtils.MachineDirection.BOTTOM, BlockEntityUtils.MachineDirection.LEFT)
                //
                .setDirectionsBySlot(2, BlockEntityUtils.MachineDirection.BOTTOM, BlockEntityUtils.MachineDirection.LEFT).validUpgrades(ContainerO2OProcessor.VALID_UPGRADES).valid(machineValidator()));
        addProcessor(new ComponentProcessor(this).canProcess(component -> component.canProcessItem2ItemRecipe(component, BlastCraftRecipeInit.BLAST_COMPRESSOR_TYPE.get())).process(component -> component.processItem2ItemRecipe(component)));
        addComponent(new ComponentContainerProvider("container.blastcompressor", this).createMenu((id, player) -> new ContainerO2OProcessor(id, player, getComponent(IComponentType.Inventory), getCoordsArray())));
    }

    protected void tickClient(ComponentTickable tickable) {
        boolean running = shouldPlaySound();
        if (running && level.random.nextDouble() < 0.15) {
            Direction direction = getFacing();
            double d4 = level.random.nextDouble();
            double d5 = direction.getAxis() == Direction.Axis.X ? direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1) : d4;
            double d6 = level.random.nextDouble();
            double d7 = direction.getAxis() == Direction.Axis.Z ? direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1) : d4;
            level.addParticle(ParticleTypes.SMOKE, worldPosition.getX() + d5, worldPosition.getY() + d6, worldPosition.getZ() + d7, 0.0D, 0.0D, 0.0D);
        }
        if (running && !isPlaying) {
            isPlaying = true;
            SoundBarrierMethods.playTileSound(BlastcraftSounds.SOUND_BLASTCOMPRESSOR.get(), this, true);
        }
    }

    @Override
    public void setNotPlaying() {
        isPlaying = false;
    }

    @Override
    public boolean shouldPlaySound() {
        return isProcessorActive();
    }

    @Override
    public int getComparatorSignal() {
        return isProcessorActive() ? 15 : 0;
    }

}