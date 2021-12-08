package commands;


import module.Token;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Command {
    public ArrayList<ValuePair> valuePairs;
    private static final HashSet<String> acceptArgs = new HashSet<>();
    private static final HashSet<String> acceptRoots = new HashSet<>() {{
        add("user");
        add("recipe");
        add("exit");
    }};

    public Command() {
    }

    /**
     * Abstract method to execute the command, will be implemented by children classes.
     */
    public abstract void execute();

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
     *
     * @param commandLine The `commandLine` to be processed.
     */
    public void run(String commandLine) {
        Token token = new Token(commandLine);
        if (!acceptRoots.contains(token.root)) {
            throw new Error("Invalid command.");
        }
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for (String rawValuePair : valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid command");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }
}
