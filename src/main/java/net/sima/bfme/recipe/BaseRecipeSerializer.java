package net.sima.bfme.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.Level;
import net.sima.bfme.screen_menus.crafting_help.ShapedRecipePatternCodecs;

import java.util.function.BiFunction;

public class BaseRecipeSerializer<T extends BaseRecipe> implements RecipeSerializer<T> {
    private final MapCodec<T> codec;
    private final BiFunction<ShapedRecipePattern, ItemStack, T> recipeConstructor;

    public BaseRecipeSerializer(BiFunction<ShapedRecipePattern, ItemStack, T> recipeConstructor) {
        this.codec = createCodec(recipeConstructor);
        this.recipeConstructor = recipeConstructor;
    }

    private static <T extends BaseRecipe> MapCodec<T> createCodec(BiFunction<ShapedRecipePattern, ItemStack, T> constructor) {
        return RecordCodecBuilder.mapCodec((builder) ->
                builder.group(
                        ShapedRecipePatternCodecs.MAP_CODEC.forGetter(recipe -> recipe.pattern),
                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
                ).apply(builder, constructor)
        );
    }

    @Override
    public MapCodec<T> codec() {
        return codec;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
        return StreamCodec.of(
                (buffer, recipe) -> this.toNetwork(buffer, recipe),  // StreamEncoder
                buffer -> this.fromNetwork(buffer, null)            // StreamDecoder (Level передаётся null, если не нужен)
        );
    }

    public T fromNetwork(RegistryFriendlyByteBuf buffer, Level level) {
        ShapedRecipePattern pattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
        ItemStack result = ItemStack.STREAM_CODEC.decode(buffer);
        return recipeConstructor.apply(pattern, result);
    }

    public void toNetwork(RegistryFriendlyByteBuf buffer, T recipe) {
        ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
        ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
    }
}
