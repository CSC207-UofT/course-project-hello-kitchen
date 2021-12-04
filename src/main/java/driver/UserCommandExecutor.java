package driver;

import commands.Token;
import commands.UserCommand;
import commands.Command;
import commands.UserCommandFactory;
import manager.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class UserCommandExecutor {

    public static void main(String[] args) {
        Shell shell = new Shell();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            Token token = new Token(commandLine);
            UserCommandFactory factory = new UserCommandFactory(token);
            Command command = factory.getCommand();
            command.run(commandLine);
        }
    }
}