package commands;

import manager.UserManager;
import user.User;

public class ListUserCommand extends UserCommand{
    public UserManager userManager;

    public ListUserCommand() {

    }

    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        StringBuilder outPut = new StringBuilder();
        this.userManager = userManager.getInstance();
        User[] usersList = this.userManager.getUserList();
        for(User user: usersList) {
            outPut.append("username: ").append(user.username).append(", description: ").
                    append(user.description).append("\n");
        }
        System.out.println(outPut);
    }
}
