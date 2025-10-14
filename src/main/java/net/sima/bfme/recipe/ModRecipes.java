package net.sima.bfme.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sima.bfme.BFME;
import net.sima.bfme.recipe.recipes.HumanFurnaceRecipe;
import net.sima.bfme.recipe.recipes.GondorianRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, BFME.MOD_ID);

    public static final Supplier<RecipeSerializer<GondorianRecipe>> GONDORIAN_SERIALIZER =
            RECIPE_SERIALIZERS.register("gondorian", () -> GondorianRecipe.SERIALIZER);
    public static final Supplier<RecipeSerializer<HumanFurnaceRecipe>> HUMAN_SERIALIZER =
            RECIPE_SERIALIZERS.register("human", () -> HumanFurnaceRecipe.SERIALIZER);


    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, BFME.MOD_ID);

    public static final Supplier<RecipeType<GondorianRecipe>> GONDORIAN_TYPE =
            RECIPE_TYPES.register("gondorian_type",
                    () -> RecipeType.simple(BFME.resource("gondorian_type")));
    public static final Supplier<RecipeType<HumanFurnaceRecipe>> HUMAN_TYPE =
            RECIPE_TYPES.register("human",
                    () -> RecipeType.simple(BFME.resource("human")));
}
