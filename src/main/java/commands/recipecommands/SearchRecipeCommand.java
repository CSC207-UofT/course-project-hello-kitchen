package commands.recipecommands;

import controller.recipecontrollers.ListRecipeController;
import manager.RecipeManager;
import module.InstanceRegistry;
import module.Recipe;
import module.Token;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SearchRecipeCommand extends RecipeCommand {
    public ArrayList<ValuePair> valuePairs;
    public RecipeManager recipeManager;
    private static final HashSet<String> acceptArgs = new HashSet<>() {{
        add("keyword");
    }};

    public SearchRecipeCommand() {
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
        StringBuilder outPut = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair : this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.recipeManager = InstanceRegistry.getRecipeManager();
        ArrayList<Recipe> searchResult = this.recipeManager.searchRecipe(map.get("keyword"));
        if (searchResult.isEmpty()) {
            System.out.println("No search result available.");
        } else {
            ListRecipeController.constructOutPut(searchResult, outPut);
        }
        System.out.println(outPut);
    }

}
