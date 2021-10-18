package manager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeManagerTest {
    RecipeManager recipeManager;

    @Before
    public void setRecipeManager(){
        recipeManager = new RecipeManager();
    }

    @Test(timeout = 50)
    public void testCreateRecipe(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        recipeManager.createRecipe("salad", "vegetable", ingredients, procedures, 1);
        assertEquals("salad", recipeManager.getRecipes().get(0).getName());
    }

    @Test(timeout = 50)
    public void testAddRecipe(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        Recipe recipe = new Recipe("salad", "vegetable", ingredients, procedures, 1);
        recipeManager.addRecipe(recipe);
        assertEquals("salad", recipeManager.getRecipes().get(0).getName());
    }

    @Test(timeout = 50)
    public void testRemoveRecipe(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        Recipe recipe = new Recipe("salad", "vegetable", ingredients, procedures, 1);
        recipeManager.addRecipe(recipe);
        assertTrue(recipeManager.removeRecipe(0));
        assertFalse(recipeManager.removeRecipe(0));
    }
}
