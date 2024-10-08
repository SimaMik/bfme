package net.sima.bfme.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, BFME.MOD_ID);
    public static final Supplier<RecipeSerializer<GondorianRecipe>> GONDORIAN_CRAFTING_SERIALIZER =
            RECIPE_SERIALIZERS.register("gondorian_serializer", GondorianRecipeSerializer::new);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, BFME.MOD_ID);
    public static final Supplier<RecipeType<GondorianRecipe>> GONDORIAN_CRAFTING_TYPE =
            RECIPE_TYPES.register("gondorian_crafting_type",
            () -> RecipeType.<GondorianRecipe>simple(ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "gondorian_crafting_type")));

}
