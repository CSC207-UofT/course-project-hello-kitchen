package commands;

import manager.UserManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SignInUserCommand extends UserCommand{
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;
    private static final HashSet<String> acceptArgs = new HashSet<String>() {{
        add("username");
        add("password");
    }};

    public SignInUserCommand() {
    }

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

    public void execute() {
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.userManager = userManager.getInstance();
        this.userManager.signIn(map.get("username"), map.get("password"));
    }
}
