package manager;

import org.junit.Before;
import org.junit.Test;
import user.AdminUser;
import user.CommonUser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermissionManagerTest {
    PermissionManager permissionManager;
    AdminUser adminUser;
    CommonUser commonUser;

    @Before
    public void setPermissionManager(){
        permissionManager = new PermissionManager();
        adminUser = new AdminUser("Thomas1", "test");
        commonUser = new CommonUser("Thomas2", "test");
    }

    @Test(timeout = 50)
    public void testHasPermission(){
        assertTrue(permissionManager.hasPermission(adminUser));
        assertFalse(permissionManager.hasPermission(commonUser));
    }
}
