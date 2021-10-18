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

public class BookmarkListTest {
    BookmarkList bookmarkList;

    @Before
    public void setBookmarkList(){
        bookmarkList = new BookmarkList("test","for testing");
    }

    @Test(timeout = 50)
    public void testGetName(){
        assertEquals("test", bookmarkList.getName());
    }

    @Test(timeout = 50)
    public void testGetDescription(){
        assertEquals("for testing", bookmarkList.getDescription());
    }

    @Test(timeout = 50)
    public void testSetName(){
        bookmarkList.setName("new");
        assertEquals("new", bookmarkList.getName());
    }

    @Test(timeout = 50)
    public void testSetDescription(){
        bookmarkList.setDescription("new");
        assertEquals("new", bookmarkList.getDescription());
    }

    @Test(timeout = 50)
    public void testGetBookmark(){
        List<Bookmark> new_list = new ArrayList<>();
        assertEquals(new_list, bookmarkList.getBookmarks());
    }
}
