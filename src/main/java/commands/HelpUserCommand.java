package commands;

public class HelpUserCommand extends UserCommand{

    public HelpUserCommand() {}

    /**
     * Execute the command since there's no args to be taken in.
     * @param commandLine Keep the same structure.
     */
    @Override
    public void run(String commandLine) {
        this.execute();
    }

    public void execute() {
        String help = "User commands help guide:\n" +
                "add: Add a new user, required arguments \"username\", \"password\", \"description\"\n" +
                "delete: Delete a user with username, required arguments \"username\"\n" +
                "signin: Sign in user with username, required arguments \"username\", \"password\"\n" +
                "signout: Sign out current user, required arguments: none" +
                "current: Show the username and description of the current active user, " +
                "required arguments: none\n" +
                "list: Show the usernames and descriptions of all stored users, required arguments: none\n" +
                "modify: Modify a specified field of the user with username, " +
                "required arguments: \"username\", \"field\" " +
                "(field only accepts values \"password\" or \"description\")\n" +
                "favourite: Show the favourite list of the current active user, required arguments: none\n" +
                "help: Display help guide for user commands, required arguments: none";
        System.out.println(help);
    }

}
