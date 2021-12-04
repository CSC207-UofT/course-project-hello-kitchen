package commands;

import manager.UserManager;

import java.lang.reflect.Constructor;
import java.util.HashMap;


public class UserCommandFactory {
    public Token token;
    public HashMap<String, String> userCommandType = new HashMap<>() {{
        put("add", "commands.AddUserCommand");
        put("delete", "commands.DeleteUserCommand");
    }};
    public UserManager userManager;

    public UserCommandFactory(Token token, UserManager userManager) {
        this.token = token;
        this.userManager = userManager;
    }

    public UserCommand getCommand() {
        System.out.println(this.token.root);
        if (this.token.root.equals("user")) {
            System.out.println(1);
            try {
                System.out.println(this.userManager);
                Class command = Class.forName(this.userCommandType.get(this.token.type));
                Constructor constructor = command.getConstructor(String.class, UserManager.class);
                UserCommand userCommand = (UserCommand)constructor.newInstance(new Object[] {this.token.body, this.userManager});
                return userCommand;
            }
            catch (Exception e) {
                System.out.println(2);
                e.printStackTrace();
            }
        }
        return null;
    }
}
