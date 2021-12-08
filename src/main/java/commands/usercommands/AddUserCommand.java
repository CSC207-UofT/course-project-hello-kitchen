package commands.usercommands;

import controller.usercontrollers.AddUserController;
import manager.UserManager;
import module.InstanceRegistry;
import module.Token;
import module.User;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AddUserCommand extends UserCommand {
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;
    private static final HashSet<String> acceptArgs = new HashSet<>() {{
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
            if (!acceptArgs.contains(valuePair.field)) {
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
        this.userManager = InstanceRegistry.getUserManager();
        AddUserController.addUser(map.get("username"), map.get("password"), map.get("description"), this.userManager);
    }
}
