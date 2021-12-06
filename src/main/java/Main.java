import com.fasterxml.jackson.databind.ObjectMapper;
import commands.Command;
import commands.CommandFactory;
import commands.Token;
import driver.Shell;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        ObjectMapper mapper = new ObjectMapper();
        Shell shell = new Shell();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            run(commandLine);
        }
    }

    public static void run(String commandLine){
        Token token = new Token(commandLine);
        CommandFactory factory = new CommandFactory(token);
        Command command = factory.getCommand();
        command.run(commandLine);
    }

}
