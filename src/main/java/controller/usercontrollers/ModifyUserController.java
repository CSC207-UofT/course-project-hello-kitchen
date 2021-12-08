package controller.usercontrollers;

import manager.UserManager;
import module.User;

public class ModifyUserController {

    private ModifyUserController () {}

    public static void modifyPassword(String username, String password, UserManager userManager) {
        User user = userManager.getUser(username);
        user.password = password;
    }

    public static void modifyDescription(String username, String description, UserManager userManager) {
        User user = userManager.getUser(username);
        user.description = description;
    }
}
