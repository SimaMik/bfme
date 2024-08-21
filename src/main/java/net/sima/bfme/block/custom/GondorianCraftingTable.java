package net.sima.bfme.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.sima.bfme.screen_menus.GondorianWorkbenchMenu;

public class GondorianCraftingTable extends ModCraftingTable{
    public GondorianCraftingTable(Properties properties) {
        super(properties);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider(
                (i, inventory, player) -> new GondorianWorkbenchMenu(i, inventory, ContainerLevelAccess.create(pLevel, pPos)), Component.translatable("container.gondorian_workbench")
        );
    }
}

