package commands;


import java.util.Arrays;
import java.util.HashMap;

public class CommandFactory {
    public Token token;
    public HashMap<String, UserCommand> userCommandMap = new HashMap<>() {{
        put("add", new AddUserCommand());
        put("delete", new DeleteUserCommand());
        put("signin", new SignInUserCommand());
        put("signout", new SignOutUserCommand());
        put("current", new CurrentUserCommand());
        put("list", new ListUserCommand());
        put("modify", new ModifyUserCommand());
        put("favourite", new FavouriteUserCommand());
        put("help", new HelpUserCommand());
    }};
    public HashMap<String, RecipeCommand> recipeCommandMap = new HashMap<>() {{
        put("add", new AddRecipeCommand());
        put("delete", new DeleteRecipeCommand());
        put("show", new ShowRecipeCommand());
        put("list", new ListRecipeCommand());
        put("modify", new ModifyRecipeCommand());
        put("favourite", new FavouriteRecipeCommand());
        put("unfavourite", new UnFavouriteRecipeCommand());
        put("search", new SearchRecipeCommand());
        put("help", new HelpRecipeCommand());
    }};
    public HashMap<String, HashMap> commandMap = new HashMap<>() {{
        put("user", userCommandMap);
        put("recipe", recipeCommandMap);
    }};

    public CommandFactory(Token token) {
        this.token = token;
    }

    private String getKeysRepr(HashMap map) {
        return Arrays.toString(map.keySet().toArray());
    }

    /**
     * Using the hashmap stored, identify the root and type of the token, and process it as required.
     * Command according to the query will be produced and returned.
     * @return The command according to the query.
     */
    public Command getCommand() {
        HashMap subcommandMap = this.commandMap.get(this.token.root);
        if (subcommandMap == null) {
            String acceptedCommands = this.getKeysRepr(commandMap);
            throw new Error(
                "Unrecognized command '" + this.token.root + "'. Accepted commands are: " + acceptedCommands + "."
            );
        }
        Command command = (Command) this.commandMap.get(this.token.root).get(this.token.type);
        if (command == null) {
            String acceptedSubcommands = this.getKeysRepr(subcommandMap);
            throw new Error(
                "Unrecognized subcommand '" + this.token.type + "' for command '" + this.token.root + "'. " +
                "Accepted subcommands are: " + acceptedSubcommands + "."
            );
        }
        return command;
    }
}
