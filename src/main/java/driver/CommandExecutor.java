package driver;

import commands.Token;
import commands.Command;
import commands.CommandFactory;

import java.util.Scanner;

public class CommandExecutor {

    public static void main(String[] args) {
        Shell shell = new Shell();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            Token token = new Token(commandLine);
            CommandFactory factory = new CommandFactory(token);
            Command command = factory.getCommand();
            command.run(commandLine);
        }
    }
}