package commands.usercommands;

import commands.Command;
import module.Token;
import module.ValuePair;

import java.util.ArrayList;
import java.util.HashSet;

public class UserCommand extends Command {
    private static final HashSet<String> acceptArgs = new HashSet<>();
    private static final HashSet<String> acceptRoots = new HashSet<>() {{
        add("user");
    }};

    public UserCommand() {
    }

    /**
     * Execute the command.
     */
    public void execute() {
    }

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
     *
     * @param commandLine The `commandLine` to be processed.
     */
    public void run(String commandLine) {
        Token token = new Token(commandLine);
        if (!acceptRoots.contains(token.root)) {
            throw new Error("Invalid user command.");
        }
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for (String rawValuePair : valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid user command.");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }
}
