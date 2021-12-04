package commands;

import manager.UserManager;


public class SignOutUserCommand extends UserCommand{
    public UserManager userManager;

    public SignOutUserCommand() {
    }

    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        this.userManager = userManager.getInstance();
        this.userManager.signOut();
    }
}
