package commands;

import manager.UserManager;

import java.util.HashMap;


public class UserCommandFactory {
    public Token token;
    public HashMap<String, Command> userCommandType = new HashMap<>() {{
        put("add", new AddUserCommand());
        put("delete", new DeleteUserCommand());
    }};

    public UserCommandFactory(Token token) {
        this.token = token;
    }

    public Command getCommand() {
        if (this.token.root.equals("user")) {
                return this.userCommandType.get(this.token.type);
            }
        return null;
    }
}
