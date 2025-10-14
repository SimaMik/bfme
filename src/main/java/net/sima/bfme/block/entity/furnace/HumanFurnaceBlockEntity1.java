package net.sima.bfme.block.entity.furnace;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.block.entity.BaseFurnaceBlockEntity;
import net.sima.bfme.block.entity.ModBlockEntities;
import net.sima.bfme.recipe.ModRecipes;
import net.sima.bfme.screen_menus.crafting_menus.HumanFurnaceMenu;

public class HumanFurnaceBlockEntity1 extends BaseFurnaceBlockEntity {
    public HumanFurnaceBlockEntity1(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HUMAN_FURNACE.get(), pos, state, ModRecipes.HUMAN_TYPE.get());
    }

    protected Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new HumanFurnaceMenu(id, player, this, this.dataAccess);
    }


}
