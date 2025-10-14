package net.sima.bfme.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BaseFurnaceRecipeSerializer <T extends BaseFurnaceRecipe> implements RecipeSerializer<T> {
    private final BaseFurnaceRecipe.Factory<T> factory;
    private final MapCodec<T> codec;
    private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;
    private static final int DEFAULT_COOKING_TIME = 200; // Значение по умолчанию

    public BaseFurnaceRecipeSerializer(BaseFurnaceRecipe.Factory<T> factory) {
        this.factory = factory;
        this.codec = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                        Ingredient.CODEC.fieldOf("bottomIngredient").forGetter(recipe -> recipe.bottomIngredient),
                        Ingredient.CODEC.fieldOf("topIngredient").forGetter(recipe -> recipe.topIngredient),
                        ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                        Codec.INT.optionalFieldOf("cookingtime", DEFAULT_COOKING_TIME).forGetter(recipe -> recipe.cookingTime)
                ).apply(instance, factory::create)
        );
        this.streamCodec = StreamCodec.of(this::toNetwork, this::fromNetwork);
    }

    @Override
    public MapCodec<T> codec() {
        return this.codec;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
        return this.streamCodec;
    }

    private void toNetwork(RegistryFriendlyByteBuf buffer, T recipe) {
        Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.topIngredient);
        Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.bottomIngredient);
        ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        buffer.writeVarInt(recipe.cookingTime);
    }
    private T fromNetwork(RegistryFriendlyByteBuf buffer) {
        Ingredient bottomIngredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
        Ingredient topIngredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
        ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
        int i = buffer.readVarInt();
        return this.factory.create(bottomIngredient, topIngredient, itemstack, i);
    }


    public BaseFurnaceRecipe create(
            Ingredient bottomIngredient, Ingredient topIngredient, ItemStack result, int cookingTime
    ) {
        return this.factory.create(bottomIngredient, topIngredient, result, cookingTime);
    }
}
