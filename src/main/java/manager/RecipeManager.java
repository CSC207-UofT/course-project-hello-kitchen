package manager;

import module.Recipe;

import java.util.ArrayList;

public class RecipeManager extends Manager {
    private final ArrayList<Recipe> recipes;
    private int counter;
    private static RecipeManager instance;

    private RecipeManager() {
        this.recipes = new ArrayList<>();
        this.counter = 0;
    }

    /**
     * Add a recipe to the manager and auto-assign an `id`.
     * @param recipe The recipe to manage.
     */
    public void createRecipe(Recipe recipe) {
        recipe.id = this.counter;
        recipes.add(recipe);
        counter += 1;
        System.out.println("Add recipe name: " + recipe.name);
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

    /**
     * Get recipe with `id`.
     * @param id The `id` of the desired recipe.
     * @return The recipe with `id`.
     */
    public Recipe getRecipe(int id) {
        for(Recipe recipe: recipes) {
            if(recipe.id == id) {
                return recipe;
            }
        }
        throw new Error("Recipe not found.");
    }

    /**
     * Get recipe list in this manager.
     * @return The recipe list in this manager.
     */
    public ArrayList<Recipe> getRecipeList() {
        return recipes;
    }

    /**
     * Get a list of recipes according to desired `keyWord`.
     * If a recipe contains the `keyWord` in the name or description, it will be added to the list.
     * @param keyword The desired keyWord for searching.
     * @return A list of recipes which satisfy search conditions, empty list if no such recipe found.
     */
    public ArrayList<Recipe> searchRecipe(String keyword) {
        ArrayList<Recipe> searchResult = new ArrayList<>();
        for(Recipe recipe: recipes) {
            if(recipe.name.contains(keyword) || recipe.description.contains(keyword)) {
                searchResult.add(recipe);
            }
        }
        return searchResult;
    }

    public static RecipeManager getInstance() {
        if(instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }
}
