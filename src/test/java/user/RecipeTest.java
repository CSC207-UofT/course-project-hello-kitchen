package user;

import org.junit.Assert;
import org.junit.Test;
import recipe.Recipe;

import java.util.HashMap;

public class RecipeTest {
    @Test
    public void testRecipe() {
        HashMap<String, String> ingredients = new HashMap<>();
        HashMap<Integer, String> procedure = new HashMap<>();
        ingredients.put("Meat", "Pork");
        procedure.put(1, "boil 10min");
        Recipe recipe = new Recipe("soup", "edible", ingredients, procedure, 10);
        String expectedName = "soup";
        Integer expectedCookingTime = 10;
        String expectedDescription = "edible";

        Assert.assertEquals(recipe.name, expectedName);
        Assert.assertEquals(recipe.estimatedCookingTime, java.util.Optional.of(expectedCookingTime));
        Assert.assertEquals(recipe.description, expectedDescription);
        Assert.assertEquals(recipe.ingredients, ingredients);
        Assert.assertEquals(recipe.procedures, procedure);
    }
}
