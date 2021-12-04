package commands;

import manager.UserManager;
import user.User;

public class CurrentUserCommand extends UserCommand{
    public UserManager userManager;

    public CurrentUserCommand() {

    }

    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        this.userManager = userManager.getInstance();
        User curr = this.userManager.getCurrentUser();
        System.out.println("Current User is, username:" + curr.username + ", description:" + curr.description);
    }
}