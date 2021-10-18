package user;

import bookmark.BookmarkList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CommonUserTest {
    CommonUser commonUser;


    @Before
    public void setCommonUser(){commonUser = new CommonUser("Thomas", "Test Registration");}

    @Test(timeout = 50)
    public void testGetBookmarkList(){
        List<BookmarkList> empty = new ArrayList<>();
        assertEquals(empty, commonUser.getBookmarkLists());
    }

    @Test(timeout = 50)
    public void testSetBookmarkList(){
        List<BookmarkList> bookmarkLists = new ArrayList<>();
        BookmarkList bookmarkList = new BookmarkList("test1","test purpose");
        bookmarkLists.add(0, bookmarkList);
        commonUser.setBookmarkLists(bookmarkLists);
        assertEquals(bookmarkLists, commonUser.getBookmarkLists());
    }

    @Test(timeout = 50)
    public void testCreateList(){
        commonUser.createList("test2","test purpose");
        List<BookmarkList> bookmarkLists = commonUser.getBookmarkLists();
        assertEquals(bookmarkLists.get(0).getName(), "test2");
    }

    @Test(timeout = 50)
    public void testDeleteList(){
        commonUser.createList("test2","test purpose");
        List<BookmarkList> bookmarkLists = commonUser.getBookmarkLists();
        assertTrue(commonUser.deleteList(0));
        assertFalse(commonUser.deleteList(0));
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "User{usertype='CommonUser', username='Thomas'}";
        assertEquals(name, commonUser.toString());
    }
}
