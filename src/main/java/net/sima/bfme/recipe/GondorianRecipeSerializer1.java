//package net.sima.bfme.recipe;//package net.sima.bfme.recipe;
//
//import com.google.common.collect.Maps;
//import com.mojang.serialization.MapCodec;
//import net.minecraft.core.NonNullList;
//import net.minecraft.network.RegistryFriendlyByteBuf;
//import net.minecraft.network.codec.StreamCodec;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.sima.bfme.BFME;
//
//import java.util.Map;
//
//public class GondorianRecipeSerializer implements RecipeSerializer<GondorianRecipe> {
//    public static final GondorianRecipeSerializer INSTANCE = new GondorianRecipeSerializer();
//    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(BFME.MOD_ID, "gondor_crafting_serializer");
//
//    @Override
//    public MapCodec<GondorianRecipe> codec() {
//        return GondorianRecipe.CODEC;
//    }
//
//    @Override
//    public StreamCodec<RegistryFriendlyByteBuf, GondorianRecipe> streamCodec() {
//        return StreamCodec.of(GondorianRecipeSerializer::toNetwork, GondorianRecipeSerializer::fromNetwork);
//    }
//
//    private static GondorianRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
//        ResourceLocation id = buffer.readResourceLocation();
//        ItemStack result = ItemStack.STREAM_CODEC.decode(buffer);
//        int size = buffer.readVarInt();
//        NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
//        ingredients.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
//        NonNullList<String> pattern = NonNullList.create();
//        int patternSize = buffer.readVarInt();
//        for (int i = 0; i < patternSize; i++) {
//            pattern.add(buffer.readUtf());
//        }
//        int keySize = buffer.readVarInt();
//        Map<Character, Ingredient> key = Maps.newHashMap();
//        for (int i = 0; i < keySize; i++) {
//            key.put(buffer.readChar(), Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
//        }
//        return new GondorianRecipe(id, result, ingredients, pattern, key);
//    }
//
//    private static void toNetwork(RegistryFriendlyByteBuf buffer, GondorianRecipe recipe) {
//        buffer.writeResourceLocation(recipe.getId());
//        ItemStack.STREAM_CODEC.encode(buffer, recipe.getResultItem(null));
//        buffer.writeVarInt(recipe.getIngredients().size());
//        for (Ingredient ingredient : recipe.getIngredients()) {
//            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
//        }
//        buffer.writeVarInt(recipe.getPattern().size());
//        for (String pattern : recipe.getPattern()) {
//            buffer.writeUtf(pattern);
//        }
//        buffer.writeVarInt(recipe.getKey().size());
//        for (Map.Entry<Character, Ingredient> entry : recipe.getKey().entrySet()) {
//            buffer.writeChar(entry.getKey());
//            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, entry.getValue());
//        }
//    }
//}
