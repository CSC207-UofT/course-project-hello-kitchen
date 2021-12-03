package commands;



public abstract class Command {
    public String commandBody;

    public Command(String commandBody){
        this.commandBody = commandBody;
    }

    public void execute(){}

}
