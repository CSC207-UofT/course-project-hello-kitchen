package commands;

import manager.UserManager;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AddUserCommand extends UserCommand {
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;
    private static final HashSet<String> acceptArgs = new HashSet<String>() {{
        add("username");
        add("password");
        add("description");
    }};

    public AddUserCommand() {
    }

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
     * @param commandLine The `commandLine` to be processed.
     */
    @Override
    public void run(String commandLine) {
        Token token = new Token(commandLine);
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for(String rawValuePair: valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!this.acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid Command");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        User user = new User(map.get("username"), map.get("password"), map.get("description"));
        this.userManager = userManager.getInstance();
        this.userManager.register(user);
    }
}
