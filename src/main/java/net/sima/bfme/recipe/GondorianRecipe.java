//package net.sima.bfme.recipe;
//
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.MapCodec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.core.NonNullList;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.inventory.CraftingContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.*;
//import net.minecraft.world.level.Level;
//import net.sima.bfme.block.ModBlocks;
//
//import java.util.Map;
//
//import static net.sima.bfme.recipe.ModRecipes.GONDORIAN_CRAFTING_SERIALIZER;
//import static net.sima.bfme.recipe.ModRecipes.GONDORIAN_CRAFTING_TYPE;
//
//public class GondorianRecipe implements CraftingRecipe {
//    public final ShapedRecipePattern pattern;
//    private final ResourceLocation id;
//    private final ItemStack result;
//    private final NonNullList<Ingredient> ingredients;
//    private final Map<Character, Ingredient> key;
//
//    public GondorianRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> ingredients, ShapedRecipePattern pattern, Map<Character, Ingredient> key) {
//        this.id = id;
//        this.result = result;
//        this.ingredients = ingredients;
//        this.pattern = pattern;
//        this.key = key;
//    }
//
//    @Override
//    public boolean matches(CraftingInput craftingInput, Level level) {
//        return this.pattern.matches(craftingInput);
//    }
//
//    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
//        return this.getResultItem(registries).copy();
//    }
//
//    @Override
//    public boolean canCraftInDimensions(int width, int height) {
//        return width * height >= ingredients.size();
//    }
//
//    @Override
//    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
//        return result;
//    }
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return GONDORIAN_CRAFTING_SERIALIZER.get();
//    }
//
//    @Override
//    public RecipeType<?> getType() {
//        return GONDORIAN_CRAFTING_TYPE.get();
//    }
//
//    @Override
//    public NonNullList<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    @Override
//    public ItemStack getToastSymbol() {
//        return new ItemStack(ModBlocks.GONDORIAN_WORKBENCH.get());
//    }
//
//    public ResourceLocation getId() {
//        return id;
//    }
//
//    public ItemStack getResult() {
//        return result;
//    }
//
//    public ShapedRecipePattern getPattern() {
//        return pattern;
//    }
//
//    public Map<Character, Ingredient> getKey() {
//        return key;
//    }
//
//    public static final MapCodec<GondorianRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
//            instance.group(
//                    ResourceLocation.CODEC.fieldOf("id").forGetter(GondorianRecipe::getId),
//                    ItemStack.CODEC.fieldOf("result").forGetter(GondorianRecipe::getResult),
//                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(recipe -> recipe.getIngredients().stream().toList()),
//                    Codec.STRING.listOf().fieldOf("pattern").forGetter(GondorianRecipe::getPattern),
//                    Codec.unboundedMap(Codec.STRING.xmap(s -> s.charAt(0), c -> String.valueOf(c)), Ingredient.CODEC).fieldOf("key").forGetter(GondorianRecipe::getKey)
//            ).apply(instance, (id, result, ingredients, pattern, key) ->
//                    new GondorianRecipe(id, result, NonNullList.of(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])), NonNullList.copyOf(pattern), key)
//            )
//    );
//
//}
