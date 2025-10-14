package net.sima.bfme.screen_menus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.screen_menus.crafting_menus.GondorianCraftingMenu;
import net.sima.bfme.screen_menus.crafting_menus.HumanFurnaceMenu;
import net.sima.bfme.screen_menus.custom.PrivateBlockMenu;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, BFME.MOD_ID);

    public static final Supplier<MenuType<GondorianCraftingMenu>> GONDORIAN_CRAFTING =
            MENUS.register("gondorian_menu", () -> new MenuType(GondorianCraftingMenu::create, FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>, MenuType<PrivateBlockMenu>> PRIVATE_BLOCK_MENU =
            registerMenuType("pedestal_menu", PrivateBlockMenu::new);
    public static final Supplier<MenuType<SmallPouchContainer>> SMALL_POUCH =
            MENUS.register("small_pouch", () -> new MenuType(SmallPouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<MediumPouchContainer>> MEDIUM_POUCH =
            MENUS.register("medium_pouch", () -> new MenuType(MediumPouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<LargePouchContainer>> LARGE_POUCH =
            MENUS.register("large_pouch", () -> new MenuType(LargePouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<HumanFurnaceMenu>> HUMAN_FURNACE =
            MENUS.register("human_furnace", () -> new MenuType(HumanFurnaceMenu::new, FeatureFlags.DEFAULT_FLAGS));

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                               IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }


}
