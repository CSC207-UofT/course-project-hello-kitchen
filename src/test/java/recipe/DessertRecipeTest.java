package recipe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DessertRecipeTest {
    DessertRecipe desertRecipe;

    @Before
    public void setDesertRecipe(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        desertRecipe = new DessertRecipe("test", "testing", ingredients, procedures, 1);}

    @Test(timeout = 50)
    public void testGetKeyword(){
        assertEquals("test", desertRecipe.getKeyword());
    }

    @Test(timeout = 50)
    public void testGetCategory(){
        assertEquals("Dessert", desertRecipe.getCategory());
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "Recipe{name='test', Category='Dessert', description='a common soup', ingredients={}," +
                " procedures=[], estimatedCookingTime=1.0}";
        assertEquals(name, desertRecipe.toString());
    }
}
