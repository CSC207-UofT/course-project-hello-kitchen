package commands;

public abstract class UserCommand {
    public String commandBody;

    public UserCommand (String commandBody) {
        this.commandBody = commandBody;
    }

    public UserCommand(){}

    public void execute (){}
}
