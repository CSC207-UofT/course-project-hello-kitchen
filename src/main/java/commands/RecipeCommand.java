package commands;

public abstract class RecipeCommand {

    public String commandBody;

    public RecipeCommand (String commandBody) {
        this.commandBody = commandBody;
    }

    public RecipeCommand(){}

    public void execute (){}
}
