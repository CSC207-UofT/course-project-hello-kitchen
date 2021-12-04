package commands;

import manager.UserManager;

public class UserCommand extends Command{
    public UserManager userManager;

    public UserCommand (String commandBody, UserManager userManager) {
        super(commandBody);
        this.userManager = userManager;
    }

    public void execute(){}
}
