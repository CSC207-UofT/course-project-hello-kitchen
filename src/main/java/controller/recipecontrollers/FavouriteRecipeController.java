package controller.recipecontrollers;

import manager.RecipeManager;
import manager.UserManager;
import module.Recipe;

public class FavouriteRecipeController {

    private FavouriteRecipeController() {}

    public static void favouriteRecipe(int id, RecipeManager recipeManager, UserManager userManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        userManager.favourite(recipe);
    }

    public static void unFavouriteRecipe(int id, RecipeManager recipeManager, UserManager userManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        userManager.unFavourite(recipe);
    }
}
