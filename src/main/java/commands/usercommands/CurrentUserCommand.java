package commands.usercommands;

import manager.UserManager;
import module.InstanceRegistry;
import module.User;

public class CurrentUserCommand extends UserCommand {
    public UserManager userManager;

    public CurrentUserCommand() {

    }

    /**
     * Execute the command since there's no args to be taken in.
     * @param commandLine Keep the same structure.
     */
    @Override
    public void run(String commandLine) {
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        this.userManager = InstanceRegistry.getUserManager();
        User curr = this.userManager.getCurrentUser();
        System.out.println("Current User is, username:" + curr.username + ", description:" + curr.description);
    }
}