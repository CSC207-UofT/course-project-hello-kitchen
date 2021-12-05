package driver;



import commands.Command;
import commands.CommandFactory;
import commands.Token;

import java.util.Scanner;


public class HelloKitchen {

    public static void run(String commandLine){
        Token token = new Token(commandLine);
        CommandFactory factory = new CommandFactory(token);
        Command command = factory.getCommand();
        command.run(commandLine);
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            run(commandLine);
        }
    }

}
