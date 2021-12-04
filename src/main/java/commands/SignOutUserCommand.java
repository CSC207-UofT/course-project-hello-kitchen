package commands;

import manager.UserManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SignOutUserCommand extends UserCommand{
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;
    private static final HashSet<String> acceptArgs = new HashSet<String>() {{
    }};

    public SignOutUserCommand() {
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
        this.userManager = userManager.getInstance();
        this.userManager.signOut();
    }
}
