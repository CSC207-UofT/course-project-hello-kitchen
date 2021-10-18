package recipe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class DessertRecipeTest {
    DessertRecipe dessertRecipe;

    @Before
    public void setDessert(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        dessertRecipe = new DessertRecipe("pie", "a pie", ingredients, procedures, 1);}

    @Test(timeout = 50)
    public void testGetKeyword(){
        assertEquals("pie", dessertRecipe.getKeyword());
    }

    @Test(timeout = 50)
    public void testGetCategory(){
        assertEquals("Dessert", dessertRecipe.getCategory());
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "Recipe{name='pie', Category='Dessert', description='a pie', ingredients={}," +
                " procedures=[], estimatedCookingTime=1.0}";
        assertEquals(name, dessertRecipe.toString());
    }

}
