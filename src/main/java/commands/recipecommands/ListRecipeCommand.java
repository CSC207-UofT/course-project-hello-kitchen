package commands.recipecommands;

import manager.RecipeManager;
import module.Recipe;

import java.util.ArrayList;


public class ListRecipeCommand extends RecipeCommand {
    public RecipeManager recipeManager;

    public ListRecipeCommand() {}

    /**
     * Execute the command since there's no args to be taken in.
     * @param commandLine Keep the same structure.
     */
    @Override
    public void run(String commandLine) {
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        StringBuilder outPut = new StringBuilder();
        this.recipeManager = RecipeManager.getInstance();
        ArrayList<Recipe> recipesList = this.recipeManager.getRecipeList();
        for (Recipe recipe : recipesList) {
            outPut.append("name: ").append(recipe.name).append(", id: ").append(recipe.id).append("\n").
                    append("description: ").append(recipe.description).append("\n");
        }
        System.out.println(outPut);
    }
}
