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
    }};
    public HashMap<String, RecipeCommand> recipeCommandType = new HashMap<>() {{
       put("delete", new DeleteRecipeCommand());
       put("show", new ShowRecipeCommand());
       put("list", new ListRecipeCommand());
    }};

    public CommandFactory(Token token) {
        this.token = token;
    }

    public Command getCommand() {
        if (this.token.root.equals("user")) {
                return this.userCommandType.get(this.token.type);
            }
        return this.recipeCommandType.get(this.token.type);
    }
}
