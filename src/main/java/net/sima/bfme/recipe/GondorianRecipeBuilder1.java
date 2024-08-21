package net.sima.bfme.recipe;//package net.sima.bfme.recipe;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRequirements;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.advancements.Criterion;
//import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
//import net.minecraft.core.NonNullList;
//import net.minecraft.data.recipes.RecipeBuilder;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.ShapedRecipePattern;
//import net.minecraft.world.level.ItemLike;
//
//import javax.annotation.Nullable;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class GondorianRecipeBuilder implements RecipeBuilder {
//    private final RecipeCategory category;
//    private final Item result;
//    private final int count;
//    private final ItemStack resultStack;
//    private final List<String> rows = Lists.newArrayList();
//    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
//    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
//    @Nullable
//    private String group;
//    private boolean showNotification = true;
//
//    public GondorianRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
//        this(category, new ItemStack(result, count));
//    }
//
//    public GondorianRecipeBuilder(RecipeCategory category, ItemStack result) {
//        this.category = category;
//        this.result = result.getItem();
//        this.count = result.getCount();
//        this.resultStack = result;
//    }
//
//    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemLike result) {
//        return shaped(category, result, 1);
//    }
//
//    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count) {
//        return new GondorianRecipeBuilder(category, result, count);
//    }
//
//    public static GondorianRecipeBuilder shaped(RecipeCategory category, ItemStack result) {
//        return new GondorianRecipeBuilder(category, result);
//    }
//
//    public GondorianRecipeBuilder define(Character symbol, TagKey<Item> tag) {
//        return this.define(symbol, Ingredient.of(tag));
//    }
//
//    public GondorianRecipeBuilder define(Character symbol, ItemLike item) {
//        return this.define(symbol, Ingredient.of(item));
//    }
//
//    public GondorianRecipeBuilder define(Character symbol, Ingredient ingredient) {
//        if (this.key.containsKey(symbol)) {
//            throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
//        } else if (symbol == ' ') {
//            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
//        } else {
//            this.key.put(symbol, ingredient);
//            return this;
//        }
//    }
//
//    public GondorianRecipeBuilder pattern(String pattern) {
//        if (!this.rows.isEmpty() && pattern.length() != this.rows.get(0).length()) {
//            throw new IllegalArgumentException("Pattern must be the same width on every line!");
//        } else {
//            this.rows.add(pattern);
//            return this;
//        }
//    }
//
//    public GondorianRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
//        this.criteria.put(name, criterion);
//        return this;
//    }
//
//    public GondorianRecipeBuilder group(@Nullable String groupName) {
//        this.group = groupName;
//        return this;
//    }
//
//    public GondorianRecipeBuilder showNotification(boolean showNotification) {
//        this.showNotification = showNotification;
//        return this;
//    }
//
//    @Override
//    public Item getResult() {
//        return this.result;
//    }
//
//    @Override
//    public void save(RecipeOutput output, ResourceLocation id) {
//        ShapedRecipePattern shapedRecipePattern = this.ensureValid(id);
//        Advancement.Builder advancementBuilder = output.advancement()
//                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
//                .rewards(AdvancementRewards.Builder.recipe(id))
//                .requirements(AdvancementRequirements.Strategy.OR);
//        this.criteria.forEach(advancementBuilder::addCriterion);
//        GondorianRecipe gondorianRecipe = new GondorianRecipe(
//                id,
//                this.resultStack,
//                NonNullList.of(Ingredient.EMPTY, this.key.values().toArray(new Ingredient[0])),
//                NonNullList.copyOf(this.rows),
//                this.key
//        );
//        output.accept(id, gondorianRecipe, advancementBuilder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
//    }
//
//    private ShapedRecipePattern ensureValid(ResourceLocation location) {
//        if (this.criteria.isEmpty()) {
//            throw new IllegalStateException("No way of obtaining recipe " + location);
//        } else {
//            return ShapedRecipePattern.of(this.key, this.rows);
//        }
//    }
//}
