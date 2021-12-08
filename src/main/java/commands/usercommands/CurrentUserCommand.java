package commands.usercommands;

import controller.usercontrollers.CurrentUserController;
import manager.UserManager;
import module.InstanceRegistry;

public class CurrentUserCommand extends UserCommand {
    public UserManager userManager;

    public CurrentUserCommand() {

    }

    /**
     * Execute the command since there's no args to be taken in.
     *
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
        StringBuilder outPut = new StringBuilder();
        CurrentUserController.showCurrent(this.userManager, outPut);
        System.out.println(outPut);
    }
}