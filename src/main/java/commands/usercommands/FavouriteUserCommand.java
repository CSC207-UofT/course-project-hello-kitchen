package commands.usercommands;

import controller.usercontrollers.FavouriteUserController;
import manager.UserManager;
import module.InstanceRegistry;
import module.Recipe;
import module.User;

import java.util.ArrayList;

public class FavouriteUserCommand extends UserCommand {
    public UserManager userManager;

    public FavouriteUserCommand() {}

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
        StringBuilder outPut = new StringBuilder();
        this.userManager = InstanceRegistry.getUserManager();
        FavouriteUserController.constructFavouriteList(this.userManager, outPut);
            System.out.println(outPut);
        }
}
