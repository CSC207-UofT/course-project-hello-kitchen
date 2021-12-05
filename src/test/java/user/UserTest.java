package user;

import org.junit.Assert;
import user.User;
import recipe.Recipe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UserTest {

    /**
     * Testing the user class
     */
    @Test
    public void testUser()
    {
        User user = new User("Jessica", "123456", "test");
        String expectedUsername = "Jessica";
        String expectedPassword = "123456";
        String expectedDescription = "test";

        Assert.assertEquals(user.username, expectedUsername);
        Assert.assertEquals(user.password, expectedPassword);
        Assert.assertEquals(user.description, expectedDescription);

        //Recipe recipe = new Recipe("Cake", "dessert",);
    }

}
