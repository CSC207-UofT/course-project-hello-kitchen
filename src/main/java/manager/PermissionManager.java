package manager;

import user.AdminUser;
import user.User;

public class PermissionManager{
    UserManager um;
    public PermissionManager(){}

    public boolean hasPermission(User user){
        return user instanceof AdminUser;
    }

/*    public AdminUser upgradeUser(User user){

        return (AdminUser) user;
    }

    public User degradeUser(AdminUser user) {
        user.setUsertype("Common");
        return ((User) user).copy();
    }*/
}
