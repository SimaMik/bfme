package net.sima.bfme.block.custom;

import net.minecraft.network.chat.Component;

public class GondorianCraftingTable extends ModCraftingTable{
    public GondorianCraftingTable(Properties properties) {
        super(properties);
    }
    @Override
    protected Component getContainerName() {
        return Component.translatable("container.gondor_workbench");
    }
}

