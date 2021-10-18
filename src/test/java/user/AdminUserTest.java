package user;

import bookmark.BookmarkList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdminUserTest {
    AdminUser adminUser;


    @Before
    public void setAdminUser(){adminUser = new AdminUser("Thomas", "Test Registration");}

    @Test(timeout = 50)
    public void testGetBookmarkList(){
        List<BookmarkList> empty = new ArrayList<>();
        assertEquals(empty, adminUser.getBookmarkLists());
    }

    @Test(timeout = 50)
    public void testSetBookmarkList(){
        List<BookmarkList> bookmarkLists = new ArrayList<>();
        BookmarkList bookmarkList = new BookmarkList("test1","test purpose");
        bookmarkLists.add(0, bookmarkList);
        adminUser.setBookmarkLists(bookmarkLists);
        assertEquals(bookmarkLists, adminUser.getBookmarkLists());
    }

    @Test(timeout = 50)
    public void testCreateList(){
        adminUser.createList("test2","test purpose");
        List<BookmarkList> bookmarkLists = adminUser.getBookmarkLists();
        assertEquals(bookmarkLists.get(0).getName(), "test2");
    }

    @Test(timeout = 50)
    public void testDeleteList(){
        adminUser.createList("test2","test purpose");
        List<BookmarkList> bookmarkLists = adminUser.getBookmarkLists();
        assertTrue(adminUser.deleteList(0));
        assertFalse(adminUser.deleteList(0));
    }

    @Test(timeout = 50)
    public void testToString(){
        String name = "User{usertype='AdminUser', username='Thomas'}";
        assertEquals(name, adminUser.toString());
    }
}
