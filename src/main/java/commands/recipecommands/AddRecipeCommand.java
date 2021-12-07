package commands.recipecommands;

import manager.RecipeManager;
import module.InstanceRegistry;
import module.Recipe;

import java.util.HashMap;
import java.util.Scanner;

public class AddRecipeCommand extends RecipeCommand {
    public RecipeManager recipeManager;

    public AddRecipeCommand() {

    }

    /**
     * Execute the command since there's no args to be taken in.
     * @param commandLine Keep the same structure.
     */
    @Override
    public void run(String commandLine){
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        this.recipeManager = InstanceRegistry.getRecipeManager();
        System.out.println("Please enter the name of the recipe:");
        String name = scanner.nextLine();
        System.out.println("Please enter the description of the recipe:");
        String description = scanner.nextLine();
        boolean moreIngredients = true;
        HashMap<String, String> ingredients = new HashMap<>();
        while (moreIngredients) {
            System.out.println("Please enter one ingredient:");
            String ingredient = scanner.nextLine();
            System.out.println("Please enter the amount of this ingredient (including unit of measurement):");
            String amount = scanner.nextLine();
            ingredients.put(ingredient, amount);
            System.out.println("Do you need to add more entry? (y/n):");
            String intention = scanner.nextLine();
            if(intention.equals("n")) {
                moreIngredients = false;
            }
        }
        boolean moreProcedures = true;
        HashMap<Integer, String> procedures = new HashMap<>();
        int counter = 1;
        while (moreProcedures) {
            System.out.println("Please enter the information of this step, Step " + counter + ":");
            String procedure = scanner.nextLine();
            procedures.put(counter, procedure);
            counter += 1;
            System.out.println("Do you need to add more entry? (y/n):");
            String intention = scanner.nextLine();
            if(intention.equals("n")) {
                moreProcedures = false;
            }
        }
        System.out.println("Please enter the estimated cooking time of this recipe (in minutes):");
        int estimatedCookingTime = Integer.parseInt(scanner.nextLine());
        Recipe recipe = new Recipe(name, description, ingredients, procedures, estimatedCookingTime);
        this.recipeManager.createRecipe(recipe);
    }

}
