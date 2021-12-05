package commands;


import java.util.HashMap;

public class CommandFactory {
    public Token token;
    public HashMap<String, UserCommand> userCommandType = new HashMap<>() {{
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
    public HashMap<String, RecipeCommand> recipeCommandType = new HashMap<>() {{
        put("add", new AddRecipeCommand());
        put("delete", new DeleteRecipeCommand());
        put("show", new ShowRecipeCommand());
        put("list", new ListRecipeCommand());
        put("modify", new ModifyRecipeCommand());
        put("favourite", new FavouriteRecipeCommand());
        put("search", new SearchRecipeCommand());
        put("help", new HelpRecipeCommand());
    }};

    public CommandFactory(Token token) {
        this.token = token;
    }

    /**
     * Using the hashmap stored, identify the root and type of the token, and process it as required.
     * Command according to the query will be produced and returned.
     * @return The command according to the query.
     */
    public Command getCommand() {
        if (this.token.root.equals("user")) {
                return this.userCommandType.get(this.token.type);
            }
        return this.recipeCommandType.get(this.token.type);
    }
}
