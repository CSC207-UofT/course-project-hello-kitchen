package commands.recipecommands;

import controller.recipecontrollers.ModifyRecipeController;
import manager.RecipeManager;
import module.InstanceRegistry;
import module.Token;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ModifyRecipeCommand extends RecipeCommand {
    public ArrayList<ValuePair> valuePairs;
    public RecipeManager recipeManager;
    private static final HashSet<String> acceptArgs = new HashSet<>() {{
        add("id");
        add("field");
    }};

    public ModifyRecipeCommand() {
    }

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
     *
     * @param commandLine The `commandLine` to be processed.
     */
    @Override
    public void run(String commandLine) {
        Token token = new Token(commandLine);
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for (String rawValuePair : valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid recipe command.");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair : this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.recipeManager = InstanceRegistry.getRecipeManager();
        if (map.get("field").equals("name")) {
            System.out.println("Please enter the new name:");
            ModifyRecipeController.modifyName(Integer.parseInt(map.get("id")), scanner.nextLine(), this.recipeManager);
        }
        if (map.get("field").equals("description")) {
            System.out.println("Please enter the new description:");
            ModifyRecipeController.modifyDescription(Integer.parseInt(map.get("id")),
                    scanner.nextLine(), this.recipeManager);
        }
        if (map.get("field").equals("time")) {
            System.out.println("Please enter the new estimated cooking time (in minutes):");
            ModifyRecipeController.modifyTime(Integer.parseInt(map.get("id")),
                    Integer.parseInt(scanner.nextLine()), this.recipeManager);
        }
        if (map.get("field").equals("ingredients")) {
            System.out.println("Please indicate your action (add/delete/modify):");
            String action = scanner.nextLine();
            if (action.equals("add")) {
                System.out.println("Please enter one ingredient:");
                String ingredient = scanner.nextLine();
                System.out.println("Please enter the amount of this ingredient (including unit of measurement):");
                String amount = scanner.nextLine();
                ModifyRecipeController.addIngredients(Integer.parseInt(map.get("id")),
                        ingredient, amount, this.recipeManager);
            }
            if (action.equals("delete")) {
                System.out.println("Please indicate the ingredient you would like to remove:");
                ModifyRecipeController.deleteIngredients(Integer.parseInt(map.get("id")),
                        scanner.nextLine(), this.recipeManager);
            }
            if (action.equals("modify")) {
                System.out.println("Please indicate the ingredient you would like to modify:");
                String ingredient = scanner.nextLine();
                System.out.println("Please enter the new amount of this ingredient (include unit of measurement):");
                String amount = scanner.nextLine();
                ModifyRecipeController.addIngredients(Integer.parseInt(map.get("id")),
                        ingredient, amount, this.recipeManager);
            }
        }
        if (map.get("field").equals("procedures")) {
            System.out.println("Please indicate your action (add/delete/modify):");
            String action = scanner.nextLine();
            if (action.equals("add")) {
                System.out.println("Please enter one procedure:");
                String procedure = scanner.nextLine();
                System.out.println("Please enter the number of the procedure:");
                int number = Integer.parseInt(scanner.nextLine());
                ModifyRecipeController.addProcedures(Integer.parseInt(map.get("id")),
                        number, procedure, this.recipeManager);
            }
            if (action.equals("delete")) {
                System.out.println("Please indicate the number of the procedure you would like to remove:");
                int number = Integer.parseInt(scanner.nextLine());
                ModifyRecipeController.deleteProcedures(Integer.parseInt(map.get("id")), number, this.recipeManager);
            }
            if (action.equals("modify")) {
                System.out.println("Please indicate the number of the procedure you would like to modify:");
                int number = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter the new procedure:");
                String procedure = scanner.nextLine();
                ModifyRecipeController.modifyProcedures(Integer.parseInt(map.get("id")),
                        number, procedure, this.recipeManager);
            }
        }
    }

}
