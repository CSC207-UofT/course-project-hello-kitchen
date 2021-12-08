package controller.usercontrollers;

import manager.UserManager;
import module.User;

public class CurrentUserController {

    private CurrentUserController() {}

    public static void showCurrent(UserManager userManager, StringBuilder outPut) {
        User curr = userManager.getCurrentUser();
        outPut.append("Current User is, username:").append(curr.username).append(", description:")
                .append(curr.description);
    }
}
