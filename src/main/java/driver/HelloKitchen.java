package driver;

import Database.Recipedata;
import Database.Userdata;
import commands.Command;
import commands.CommandExecutor;
import manager.RecipeManager;
import user.CommonUser;

import java.io.IOException;
import java.util.Scanner;


public class HelloKitchen {
    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
        CommandExecutor exectuor = new CommandExecutor();
        Scanner in = new Scanner(System.in);
        Recipedata recipedata = new Recipedata();
        System.out.println(recipedata.readData());
        Userdata userdata = new Userdata();
        System.out.println(userdata.readData());
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
        System.out.println(userdata.writeData());
        System.out.println(recipedata.writeData());
    }
}
