package use_case;

import entity.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        recipes = new ArrayList<>();
    }

    public void createRecipe(String name, String description, HashMap<String, Double> ingredients,
                             List<String> procedures, double estimatedCookingTime) {
        Recipe recipe = new Recipe(name, description, ingredients, procedures, estimatedCookingTime);
        recipes.add(recipe);
    }
    public boolean removeRecipe(int i) {
        if (i >= 0 && i < recipes.size()) {
            recipes.remove(i);
            return true;
        }
        return false;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
