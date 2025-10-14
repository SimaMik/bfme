package net.sima.bfme.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.AdvancementRequirements.Strategy;
import net.minecraft.advancements.AdvancementRewards.Builder;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
public abstract class BaseFurnaceRecipeBuilder<T extends BaseFurnaceRecipe> implements RecipeBuilder {
    protected final RecipeCategory category;
    protected final Item result;
    protected final ItemStack resultStack;
    protected Ingredient topIngredient;
    protected Ingredient bottomIngredient;
    protected int cookingTime; // Default cooking time
    protected int count; // Default cooking time
    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    @Nullable
    private String group;
    public BaseFurnaceRecipeBuilder(RecipeCategory category, ItemStack result) {
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
        this.category = category;

        // Задать базовые значения для полей, если это необходимо
        this.topIngredient = Ingredient.EMPTY;
        this.bottomIngredient = Ingredient.EMPTY;
        this.cookingTime = 200; // Время готовки по умолчанию
        this.group = null; // Группа рецептов по умолчанию
    }


    public BaseFurnaceRecipeBuilder<T> top(Ingredient ingredient) {
        this.topIngredient = ingredient;
        return this;
    }

    public BaseFurnaceRecipeBuilder<T> bottom(Ingredient ingredient) {
        this.bottomIngredient = ingredient;
        return this;
    }

    public BaseFurnaceRecipeBuilder<T> cookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public BaseFurnaceRecipeBuilder<T> unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public Item getResult() {
        return this.resultStack.getItem();
    }

    public BaseFurnaceRecipeBuilder<T> group(@javax.annotation.Nullable String groupName) {
        this.group = groupName;
        return this;
    }
    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        validate(id);

        Advancement.Builder advancementBuilder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(Builder.recipe(id))
                .requirements(Strategy.OR);

        this.criteria.forEach(advancementBuilder::addCriterion);

        T recipe = createRecipe(this.bottomIngredient, this.topIngredient, this.resultStack, this.cookingTime);

        recipeOutput.accept(id, recipe, advancementBuilder.build(id.withPrefix("recipes/furnace/" + this.category.getFolderName() + "/")));
    }

    protected abstract T createRecipe(Ingredient top, Ingredient bottom, ItemStack result, int cookingTime);

    protected void validate(ResourceLocation id) {
        if (this.topIngredient.isEmpty() || this.bottomIngredient.isEmpty() || this.resultStack.isEmpty()) {
            throw new IllegalStateException("Missing required fields for recipe " + id);
        }
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No criteria specified for unlocking recipe " + id);
        }
    }
}
