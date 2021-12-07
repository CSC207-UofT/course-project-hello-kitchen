import com.fasterxml.jackson.databind.ObjectMapper;
import commands.Command;
import commands.CommandFactory;
import module.Token;
import module.Shell;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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
