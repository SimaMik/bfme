package net.sima.bfme.recipe;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.sima.bfme.BFME;

import java.util.Map;

public class GondorianRecipeSerializer implements RecipeSerializer<GondorianRecipe> {

    public static final MapCodec<GondorianRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
                            CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(recipe -> recipe.category),
                            ShapedRecipePattern.MAP_CODEC.forGetter(recipe -> recipe.pattern),
                            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                            Codec.BOOL.optionalFieldOf("show_notification", Boolean.valueOf(true)).forGetter(recipe -> recipe.showNotification)
                    )
                    .apply(instance, GondorianRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, GondorianRecipe> STREAM_CODEC = StreamCodec.of(
            GondorianRecipeSerializer::toNetwork, GondorianRecipeSerializer::fromNetwork
    );

    @Override
    public MapCodec<GondorianRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, GondorianRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    private static GondorianRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
        String s = buffer.readUtf();
        CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
        ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
        ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
        boolean flag = buffer.readBoolean();
        return new GondorianRecipe(s, craftingbookcategory, shapedrecipepattern, itemstack, flag);
    }

    private static void toNetwork(RegistryFriendlyByteBuf buffer, GondorianRecipe recipe) {
        buffer.writeUtf(recipe.getGroup());
        buffer.writeEnum(recipe.category);
        ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
        ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        buffer.writeBoolean(recipe.showNotification);
    }
}

