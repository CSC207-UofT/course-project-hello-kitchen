package controller.recipecontrollers;

import module.Recipe;

import java.util.ArrayList;

public class ListRecipeController {

    private ListRecipeController() {}

    public static void constructOutPut(ArrayList<Recipe> recipesList, StringBuilder outPut) {
        for (Recipe recipe : recipesList) {
            outPut.append("name: ").append(recipe.name).append(", id: ").append(recipe.id).append("\n").
                    append("description: ").append(recipe.description).append("\n");
        }
    }
}
