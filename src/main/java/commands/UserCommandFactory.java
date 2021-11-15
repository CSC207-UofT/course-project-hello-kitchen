package commands;

import manager.UserManager;

import java.util.Map;

public class UserCommandFactory {
    public Token token;
    protected Map commandTypes = Map.of(
            "ADD", "Add",
            "Delete", "Delete"
    );
    public UserManager userManager;

    public UserCommandFactory(Token token, UserManager userManager) {
        this.token = token;
        this.userManager = userManager;
    }

    public UserCommand getCommand() {

        return new AddUserCommand(this.token.body, this.userManager);
    }
}
