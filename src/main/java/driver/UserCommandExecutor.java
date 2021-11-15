package driver;

import commands.Token;
import commands.UserCommand;
import commands.UserCommandFactory;
import manager.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class UserCommandExecutor {

    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
        Scanner in = new Scanner(System.in);
        UserManager userManager = new UserManager();
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            Token token = new Token(commandLine);
            UserCommandFactory factory = new UserCommandFactory(token, userManager);
            UserCommand command = factory.getCommand();
            command.execute();
        }
    }
}
