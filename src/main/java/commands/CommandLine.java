package commands;

import java.util.List;

/*
* Used to separate command line with command and argument
*/
public class CommandLine {
    private final String command;
    private final List<String> arguments;

    public CommandLine(String command, List<String> arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return this.command;
    }


    public List<String> getArguments() {
        return this.arguments;
    }

}
