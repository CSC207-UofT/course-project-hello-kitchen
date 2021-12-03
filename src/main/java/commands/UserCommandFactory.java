package commands;

import manager.UserManager;

import java.util.HashMap;


public class UserCommandFactory {
    public Token token;
    public HashMap<String, Class<?>> userCommandType = new HashMap<>() {{
        put("add", AddUserCommand.class);
        put("delete", DeleteUserCommand.class);
    }};
    public UserManager userManager;

    public UserCommandFactory(Token token, UserManager userManager) {
        this.token = token;
        this.userManager = userManager;
    }

    public UserCommand getCommand() {
        if(this.token.root.equals("user")){
            return new AddUserCommand(this.token.body, this.userManager);
        }
        return new AddUserCommand(this.token.body, this.userManager);
    }
}
