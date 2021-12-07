package commands.recipecommands;

import manager.RecipeManager;
import module.Recipe;
import module.Token;
import module.ValuePair;

import java.util.*;

public class ModifyRecipeCommand extends RecipeCommand {
    public ArrayList<ValuePair> valuePairs;
    public RecipeManager recipeManager;
    private static final HashSet<String> acceptArgs = new HashSet<>() {{
        add("id");
        add("field");
    }};

    public ModifyRecipeCommand() {}

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
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
        this.recipeManager = RecipeManager.getInstance();
        Recipe recipe = this.recipeManager.getRecipe(Integer.parseInt(map.get("id")));
        if(map.get("field").equals("name")) {
            System.out.println("Please enter the new name:");
            recipe.name = scanner.nextLine();
        }
        if(map.get("field").equals("description")) {
            System.out.println("Please enter the new description:");
            recipe.description = scanner.nextLine();
        }
        if(map.get("field").equals("time")) {
            System.out.println("Please enter the new estimated cooking time (in minutes):");
            recipe.estimatedCookingTime = Integer.parseInt(scanner.nextLine());
        }
        if(map.get("field").equals("ingredients")) {
            System.out.println("Please indicate your action (add/delete/modify):");
            String action = scanner.nextLine();
            if(action.equals("add")) {
                System.out.println("Please enter one ingredient:");
                String ingredient = scanner.nextLine();
                System.out.println("Please enter the amount of this ingredient (including unit of measurement):");
                String amount = scanner.nextLine();
                recipe.ingredients.put(ingredient, amount);
            }
            if(action.equals("delete")) {
                System.out.println("Please indicate the ingredient you would like to remove:");
                recipe.ingredients.remove(scanner.nextLine());
            }
            if (action.equals("modify")) {
                System.out.println("Please indicate the ingredient you would like to modify:");
                String ingredient = scanner.nextLine();
                System.out.println("Please enter the new amount of this ingredient (include unit of measurement):");
                String amount = scanner.nextLine();
                recipe.ingredients.put(ingredient, amount);
            }
        }
        if(map.get("field").equals("procedures")) {
            System.out.println("Please indicate your action (add/delete/modify):");
            String action = scanner.nextLine();
            if(action.equals("add")) {
                System.out.println("Please enter one procedure:");
                String procedure = scanner.nextLine();
                System.out.println("Please enter the number of the procedure:");
                int number = Integer.parseInt(scanner.nextLine());
                int counter = Collections.max(recipe.procedures.keySet());
                for(int i = counter; i >= number; i --) {
                    String currProcedure = recipe.procedures.get(i);
                    recipe.procedures.put(i + 1, currProcedure);
                }
                recipe.procedures.put(number, procedure);
            }
            if(action.equals("delete")) {
                System.out.println("Please indicate the number of the procedure you would like to remove:");
                int number = Integer.parseInt(scanner.nextLine());
                for(int i = number + 1; i <= recipe.procedures.size(); i ++) {
                    String currProcedure = recipe.procedures.get(i);
                    recipe.procedures.put(i - 1, currProcedure);
                }
                int lastEntry = recipe.procedures.size();
                recipe.procedures.remove(lastEntry);
            }
            if (action.equals("modify")) {
                System.out.println("Please indicate the number of the procedure you would like to modify:");
                String number = scanner.nextLine();
                System.out.println("Please enter the new procedure:");
                String procedure = scanner.nextLine();
                recipe.procedures.put(Integer.parseInt(number), procedure);
            }
        }
    }

}
