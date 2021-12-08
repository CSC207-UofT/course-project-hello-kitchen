package controller.usercontrollers;

import manager.UserManager;
import module.User;

public class AddUserController {

    private AddUserController() {}

    public static void addUser(String username, String password, String description, UserManager userManager) {
        User user = new User(username, password, description);
        userManager.register(user);
    }
}
