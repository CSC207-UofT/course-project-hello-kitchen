package bookmark;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import recipe.DessertRecipe;
import recipe.Recipe;
import recipe.SoupRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookmarkTest {
    Bookmark bookmark;

    @Before
    public void setBookmark(){
        HashMap<String,Double> ingredients = new HashMap<>();
        List<String> procedures = new ArrayList<>();
        SoupRecipe soupRecipe = new SoupRecipe("misosoup", "a common soup", ingredients, procedures, 1);
        bookmark = new Bookmark("remark", soupRecipe);
    }

    @Test(timeout = 50)
    public void testGetRemark(){
        assertEquals("remark", bookmark.getRemark());
    }

    @Test(timeout = 50)
    public void testSetRemark(){
        assertEquals("remark", bookmark.getRemark());
        bookmark.setRemark("new");
        assertEquals("new", bookmark.getRemark());
    }

    @Test(timeout = 50)
    public void testGetRecipe(){
       Recipe recipe = bookmark.getRecipe();
       assertEquals("misosoup", recipe.getName());
    }

    @Test(timeout = 50)
    public void testSetRecipe(){
        DessertRecipe dessertRecipe = new DessertRecipe();
        bookmark.setRecipe(dessertRecipe);
        assertTrue(bookmark.getRecipe() instanceof DessertRecipe);
    }
}
