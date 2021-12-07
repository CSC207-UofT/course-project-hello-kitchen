package commands.recipecommands;

import commands.recipecommands.RecipeCommand;
import manager.RecipeManager;
import module.Recipe;
import module.Token;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ShowRecipeCommand extends RecipeCommand {
    public ArrayList<ValuePair> valuePairs;
    public RecipeManager recipeManager;
    private static final HashSet<String> acceptArgs = new HashSet<>() {{
        add("id");
    }};

    public ShowRecipeCommand() {}

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
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.recipeManager = RecipeManager.getInstance();
        Recipe recipe = this.recipeManager.getRecipe(Integer.parseInt(map.get("id")));
        StringBuilder outPut = new StringBuilder("Recipe \n"
                + "name: " + recipe.name + "\n"
                + "id: " + recipe.id + "\n"
                + "description: " + recipe.description + "\n"
                + "Ingredients: \n");
        for (String ingredient: recipe.ingredients.keySet()) {
            outPut.append(ingredient).append(": ").append(recipe.ingredients.get(ingredient)).append("\n");
        }
        outPut.append("Steps: \n");
        for (int procedure: recipe.procedures.keySet()) {
            outPut.append("Step").append(procedure).append(": ").append(recipe.procedures.get(procedure)).append("\n");
        }
        outPut.append("Estimated cooking time: ").append(recipe.estimatedCookingTime).append(" minutes");
        System.out.println(outPut);
    }
}
