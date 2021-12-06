package manager;

import junit.framework.Assert;
import manager.UserManager;
import user.User;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UserManagerTest {


    HashMap<String, User> users = new HashMap<>();
    UserManager userManager = UserManager.getInstance();

    /**
     * Test the Error of Register method
     */
    @Test
    public void testRegisterError() {
        User user = new User("Jessica", "123456", "test");
        User testUser = new User("Jessica", "111000", "test2");
        users.put(user.username, user);
        users.put(testUser.username, testUser);
        try {
            userManager.register(user);
            userManager.register(testUser);
            fail();
        } catch (Error e){
            assertEquals(e.getMessage(), "Username occupied, change another name");
        }
    }

    /**
     * Test if the register create new user
     */
    @Test
    public void testRegister() {
        User testUser = new User("Jessica", "111000", "test2");
        userManager.register(testUser);
        Assert.assertEquals(testUser, userManager.getUser(testUser.username));
    }

    /**
     * Test the removeUser method
     */
    @Test
    public void testRemoveUser() {
        User testUser = new User("Jessica", "111000", "test2");
        userManager.register(testUser);
        userManager.removeUser(testUser.username);
        Assert.assertNull(userManager.getUser(testUser.username));
    }

    /**
     * Test the signIn method Error
     */
    @Test
    public void testSignInError() {
        User testUser = new User("Jessica", "111000", "test2");
        try {
            userManager.register(testUser);
            userManager.signIn(testUser.username, "123456");
            fail();
        } catch (Error e){
            assertEquals(e.getMessage(), "Invalid username or password.");
        }
    }
    /**
     * Test the signIn method
     */
    @Test
    public void testSignIn() {
        User testUser = new User("Jessica", "111000", "test2");
        userManager.register(testUser);
        userManager.signIn(testUser.username, testUser.password);
        Assert.assertEquals(testUser, userManager.getCurrentUser());
    }
    /**
     * Test the signOut method
     */
    @Test
    public void testSignOut() {
        User testUser = new User("Jessica", "111000", "test2");
        userManager.register(testUser);
        userManager.signIn(testUser.username, testUser.password);
        userManager.signOut();
        Assert.assertNull(userManager.getCurrentUser());
    }
    /**
     * Test the getCurrentUser method
     */
    @Test
    public void testGetCurrentUser() {
        User testUser = new User("Jessica", "111000", "test2");
        userManager.register(testUser);
        userManager.signIn(testUser.username, testUser.password);
        Assert.assertEquals(testUser, userManager.getCurrentUser());
    }
    /**
     * Test the getUser method
     */
    @Test
    public void testGetUser() {
        User testUser = new User("Jessica", "111000", "test2");
        users.put(testUser.username, testUser);
        Assert.assertEquals(testUser, userManager.getUser(testUser.username));
    }
    /**
     * Test the getUserList method
     */
    @Test
    public void testGetUserList() {
        User user = new User("Jessica", "123456", "test");
        User testUser = new User("Jessica", "111000", "test2");
        users.put(user.username, user);
        users.put(testUser.username, testUser);
        Assert.assertTrue(users.containsKey(user.username));
        Assert.assertTrue(users.containsKey(testUser.username));
    }
}
