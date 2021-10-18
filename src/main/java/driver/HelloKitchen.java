package driver;

import commands.Command;
import commands.CommandExecutor;
import user.CommonUser;

import java.io.IOException;
import java.util.Scanner;

public class HelloKitchen {
    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
        CommandExecutor exe = new CommandExecutor();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()){
            System.out.print("$ ");
            String commandLine = in.nextLine();
            try {
                String output = exe.execute(commandLine);

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
