package controller.recipecontrollers;

import manager.RecipeManager;
import module.Recipe;

import java.util.Collections;

public class ModifyRecipeController {

    private ModifyRecipeController() {}

    public static void modifyName(int id, String name, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.name = name;
    }

    public static void modifyDescription(int id, String description, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.description= description;
    }

    public static void modifyTime(int id, int time, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.estimatedCookingTime= time;
    }

    public static void addIngredients(int id, String ingredient, String amount, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.ingredients.put(ingredient, amount);
    }

    public static void deleteIngredients(int id, String ingredient, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.ingredients.remove(ingredient);
    }

    public static void addProcedures(int id, int number, String procedure, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        int counter = Collections.max(recipe.procedures.keySet());
        for(int i = counter; i >= number; i --) {
            String currProcedure = recipe.procedures.get(i);
            recipe.procedures.put(i + 1, currProcedure);
        }
        recipe.procedures.put(number, procedure);
    }

    public static void deleteProcedures(int id, int number, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        for(int i = number + 1; i <= recipe.procedures.size(); i ++) {
            String currProcedure = recipe.procedures.get(i);
            recipe.procedures.put(i - 1, currProcedure);
        }
        int lastEntry = recipe.procedures.size();
        recipe.procedures.remove(lastEntry);
    }

    public static void modifyProcedures(int id, int number,String procedure, RecipeManager recipeManager) {
        Recipe recipe = recipeManager.getRecipe(id);
        recipe.procedures.put(number, procedure);
    }
}
