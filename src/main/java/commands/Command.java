package commands;

import java.util.List;


public abstract class Command {
    protected final int maxArguments;
    protected final int minArguments;

    public Command(int maxArguments, int minArguments) {
        this.maxArguments = 16;
        this.minArguments = 0;
    }

    protected void checkArgumentsNum(List<String> arguments) throws Exception {
        if (arguments.size() > maxArguments) {
            throw new Exception("your input out of range");
        }
        if (arguments.size() < minArguments) {
            throw new Exception("you do not input anything");
        }
    }

}
