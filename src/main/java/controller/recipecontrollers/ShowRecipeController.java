package controller.recipecontrollers;

import manager.RecipeManager;
import module.Recipe;

public class ShowRecipeController {

    private ShowRecipeController() {}

    public static void showConstructor(int id, RecipeManager recipeManager, StringBuilder outPut) {
        Recipe recipe = recipeManager.getRecipe(id);
        outPut.append("Recipe \n" + "name: ").append(recipe.name).append("\n").append("id: ").
                append(recipe.id).append("\n").append("description: ").append(recipe.description).
                append("\n").append("Ingredients: \n");
        for (String ingredient: recipe.ingredients.keySet()) {
            outPut.append(ingredient).append(": ").append(recipe.ingredients.get(ingredient)).append("\n");
        }
        outPut.append("Steps: \n");
        for (int procedure: recipe.procedures.keySet()) {
            outPut.append("Step").append(procedure).append(": ").append(recipe.procedures.get(procedure)).append("\n");
        }
        outPut.append("Estimated cooking time: ").append(recipe.estimatedCookingTime).append(" minutes");
    }
}
