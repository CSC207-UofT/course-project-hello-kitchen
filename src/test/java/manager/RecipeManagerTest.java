package manager;

import org.junit.Test;
import static org.junit.Assert.*;

import recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeManagerTest {
    RecipeManager recipeManager = RecipeManager.getInstance();

    @Test
    public void testCreateRecipe() {
        HashMap<String, String> ingredients = new HashMap<>();
        HashMap<Integer, String> procedure = new HashMap<>();
        Recipe recipe = new Recipe("soup", "edible", ingredients, procedure, 10);
        recipeManager.createRecipe(recipe);
        assertEquals(recipe, recipeManager.getRecipe(1));
    }

    @Test
    public void testRemoveRecipe() {
        try {
            recipeManager.removeRecipe(1);
            fail();
        } catch (Error e){
            assertEquals(e.getMessage(), "Recipe not found.");
        }
    }


    @Test
    public void testGetRecipe() {
        try {
            recipeManager.getRecipe(1);
            fail();
        } catch (Error e){
            assertEquals(e.getMessage(), "Recipe not found.");
        }
    }

    @Test
    public void testSearchRecipe() {
        HashMap<String, String> ingredients = new HashMap<>();
        HashMap<Integer, String> procedure = new HashMap<>();
        Recipe recipe = new Recipe("soup", "edible", ingredients, procedure, 10);
        ArrayList<Recipe> searchResult = new ArrayList<>();
        searchResult.add(recipe);
        recipeManager.createRecipe(recipe);
        assertEquals(searchResult, recipeManager.searchRecipe("soup"));
    }
}
