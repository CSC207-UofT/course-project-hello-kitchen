package manager;

import recipe.Recipe;

import java.util.ArrayList;

public class RecipeManager extends Manager {
    private ArrayList<Recipe> recipes;
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

    public static RecipeManager getInstance() {
        if(instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }
}
