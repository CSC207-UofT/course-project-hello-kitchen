package manager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagerTest {
    UserManager userManager;

    @Before
    public void setUserManager(){
        userManager = new UserManager();
    }

    @Test(timeout = 50)
    public void testCreateCommonUser(){
        userManager.createCommonUser("Thomas", "test");
        assertEquals("Thomas", userManager.getUsers().get(0).getUserName());
    }

    @Test(timeout = 50)
    public void testCreateAdminUser(){
        userManager.createAdminUser("Thomas", "test");
        assertEquals("Thomas", userManager.getUsers().get(0).getUserName());
    }

    @Test(timeout = 50)
    public void testRemoveUser(){
        userManager.createCommonUser("Thomas", "test");
        assertTrue(userManager.removeUser(0));
        assertFalse(userManager.removeUser(0));
    }
}
