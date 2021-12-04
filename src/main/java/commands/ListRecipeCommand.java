package commands;

import manager.RecipeManager;
import recipe.Recipe;

import java.util.ArrayList;


public class ListRecipeCommand extends RecipeCommand{
    public RecipeManager recipeManager;

    public ListRecipeCommand() {}

    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        StringBuilder outPut = new StringBuilder();
        this.recipeManager = recipeManager.getInstance();
        ArrayList<Recipe> recipesList = this.recipeManager.getRecipeList();
        for (Recipe recipe : recipesList) {
            outPut.append("name: ").append(recipe.name).append(", id: ").append(recipe.id).append("\n").
                    append("description: ").append(recipe.description);
        }
        System.out.println(outPut);
    }
}
