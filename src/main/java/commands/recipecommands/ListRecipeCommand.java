package commands.recipecommands;


import controller.recipecontrollers.ListRecipeController;
import manager.RecipeManager;
import module.InstanceRegistry;
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
        this.recipeManager = InstanceRegistry.getRecipeManager();
        ArrayList<Recipe> recipesList = this.recipeManager.getRecipes();
        ListRecipeController.constructOutPut(recipesList, outPut);
        System.out.println(outPut);
    }
}
