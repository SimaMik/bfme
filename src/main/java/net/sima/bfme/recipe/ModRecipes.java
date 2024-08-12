//package net.sima.bfme.recipe;
//
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.item.crafting.RecipeType;
//import net.neoforged.neoforge.registries.DeferredHolder;
//import net.neoforged.neoforge.registries.DeferredRegister;
//import net.sima.bfme.BFME;
//
//public class ModRecipes {
//    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, BFME.MOD_ID);
//    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, BFME.MOD_ID);
//
//    public static final DeferredHolder<RecipeSerializer<?>, GondorianRecipeSerializer> GONDORIAN_CRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register(GondorianRecipeSerializer.ID.getPath(), () -> GondorianRecipeSerializer.INSTANCE);
//    public static final DeferredHolder<RecipeType<?>, GondorianRecipeType> GONDORIAN_CRAFTING_TYPE = TYPES.register(GondorianRecipeType.ID, () -> GondorianRecipeType.INSTANCE);
//}
