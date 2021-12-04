package commands;

import manager.UserManager;

import java.util.ArrayList;
import java.util.HashSet;

public class UserCommand extends Command{
    private static final HashSet<String> acceptArgs = new HashSet<>();
    private static final HashSet<String> acceptRoots = new HashSet<String>() {{
        add("user");
    }};

    public UserCommand () {
    }

    public void execute(){}

    public void run(String commandLine){
        Token token = new Token(commandLine);
        if(!acceptRoots.contains(token.root)) {
            throw new Error("Invalid user command.");
        }
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for(String rawValuePair: valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!this.acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid user command.");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }
}
