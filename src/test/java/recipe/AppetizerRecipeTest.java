package recipe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppetizerRecipeTest {
    AppetizerRecipe appetizerRecipe;

    @Before
    public void setAppetizer(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        appetizerRecipe = new AppetizerRecipe("salad", "vegetable", ingredients, procedures, 1);}

    @Test(timeout = 50)
    public void testGetKeyword(){
        assertEquals("salad", appetizerRecipe.getKeyword());
    }

    @Test(timeout = 50)
    public void testGetCategory(){
        assertEquals("Appetizer", appetizerRecipe.getCategory());
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "Recipe{name='salad', Category='Appetizer', description='vegetable', ingredients={}," +
                " procedures=[], estimatedCookingTime=1.0}";
        assertEquals(name, appetizerRecipe.toString());
    }
}
