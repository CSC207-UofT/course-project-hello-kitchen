package driver;

import DiskIO.DiskOperator;
import commands.CommandExecutor;

import java.io.IOException;
import java.util.Scanner;

import static DiskIO.DiskOperator.*;


public class HelloKitchen {
    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
        CommandExecutor exectuor = new CommandExecutor();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()){
            System.out.print("$ ");
            String commandLine = in.nextLine();
            try {
                String output = exectuor.execute(commandLine);

            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
