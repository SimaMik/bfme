package net.sima.bfme.screen_menus;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;

import java.util.function.Supplier;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, BFME.MOD_ID);
//    public static final Supplier<MenuType<GondorianWorkbenchMenu>> GONDORIAN_WORKBENCH_MENU =
//            MENUS.register("gondorian_workbench", () -> new MenuType(GondorianWorkbenchMenu::new, FeatureFlags.DEFAULT_FLAGS));


    public static final Supplier<MenuType<SmallPouchContainer>> SMALL_POUCH =
            MENUS.register("small_pouch", () -> new MenuType(SmallPouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<MediumPouchContainer>> MEDIUM_POUCH =
            MENUS.register("medium_pouch", () -> new MenuType(MediumPouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<LargePouchContainer>> LARGE_POUCH =
            MENUS.register("large_pouch", () -> new MenuType(LargePouchContainer::new, FeatureFlags.DEFAULT_FLAGS));
}
