package controller.usercontrollers;

import module.User;

public class ListUserController {

    private ListUserController() {}

    public static void constructUserList(User[] usersList, StringBuilder outPut) {
        for(User user: usersList) {
            outPut.append("username: ").append(user.username).append(", description: ").
                    append(user.description).append("\n");
        }
    }
}
