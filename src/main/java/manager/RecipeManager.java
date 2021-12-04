package manager;

import recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;
    private int counter;

    public RecipeManager() {
        this.recipes = new ArrayList<>();
        this.counter = 0;
    }

    /**
     * Add a recipe to the manager and auto-assign an `id`.
     * @param recipe The recipe to manage.
     */
    public void createRecipe(Recipe recipe) {
        int id = this.counter;
        recipe.id = id;
        recipes.add(recipe);
        counter += 1;
        System.out.println("Add recipe name:" + recipe.name);
    }

    /**
     * Remove a recipe with `id`.
     * @param id The `id` of the recipe to remove.
     */
    public void removeRecipe(int id) {
        for(Recipe recipe: recipes) {
            if(recipe.id == id) {
                recipes.remove(recipe);
                System.out.println("Remove successful.");
                return;
            }
        }
        throw new Error("Recipe not found.");
    }

    public Recipe getRecipe(int id) {
        for(Recipe recipe: recipes) {
            if(recipe.id == id) {
                return recipe;
            }
        }
        throw new Error("Recipe not found.");
    }

    public List<Recipe> getRecipeList() {
        return recipes;
    }
}
