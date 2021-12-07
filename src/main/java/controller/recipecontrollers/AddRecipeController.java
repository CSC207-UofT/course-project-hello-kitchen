package controller.recipecontrollers;

import manager.RecipeManager;
import module.Recipe;

import java.util.HashMap;

public class AddRecipeController {

    private AddRecipeController() {}

    public static void addRecipe(String name, String description,
                                 HashMap<String, String> ingredients,
                                 HashMap<Integer, String >procedures,
                                 int estimatedCookingTime, RecipeManager recipeManager) {
        Recipe recipe = new Recipe(name, description, ingredients, procedures, estimatedCookingTime);
        recipeManager.createRecipe(recipe);
    }
}
