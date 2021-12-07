package commands.usercommands;

import manager.UserManager;
import module.InstanceRegistry;
import module.User;

public class ListUserCommand extends UserCommand {
    public UserManager userManager;

    public ListUserCommand() {

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
        StringBuilder outPut = new StringBuilder();
        this.userManager = InstanceRegistry.getUserManager();
        User[] usersList = this.userManager.getUserList();
        for(User user: usersList) {
            outPut.append("username: ").append(user.username).append(", description: ").
                    append(user.description).append("\n");
        }
        System.out.println(outPut);
    }
}
