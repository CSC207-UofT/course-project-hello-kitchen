package commands.usercommands;

import manager.UserManager;
import module.InstanceRegistry;


public class SignOutUserCommand extends UserCommand {
    public UserManager userManager;

    public SignOutUserCommand() {
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
        this.userManager.signOut();
    }
}
