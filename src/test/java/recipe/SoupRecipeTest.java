package recipe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoupRecipeTest {
    SoupRecipe soupRecipe;

    @Before
    public void setSoup(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        soupRecipe = new SoupRecipe("misosoup", "a common soup", ingredients, procedures, 1);}

    @Test(timeout = 50)
    public void testGetKeyword(){
        assertEquals("misosoup", soupRecipe.getKeyword());
    }

    @Test(timeout = 50)
    public void testGetCategory(){
        assertEquals("Soup", soupRecipe.getCategory());
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "Recipe{name='misosoup', Category='Soup', description='a common soup', ingredients={}," +
                " procedures=[], estimatedCookingTime=1.0}";
        assertEquals(name, soupRecipe.toString());
    }

}
