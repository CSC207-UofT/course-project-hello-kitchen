import com.fasterxml.jackson.databind.ObjectMapper;
import commands.Command;
import commands.CommandFactory;
import diskoperator.DiskOperator;
import manager.RecipeManager;
import manager.UserManager;
import module.InstanceRegistry;
import module.Token;
import module.Shell;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * Use InstanceRegistry to ensure project state.
     * @param args Arguments
     * @throws IOException For data accessing purpose
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        ObjectMapper mapper = new ObjectMapper();
        DiskOperator diskOperator = new DiskOperator();
        try {
            UserManager userManager = (UserManager) diskOperator.
                    read("userManager.json", InstanceRegistry.getUserManager());
            RecipeManager recipeManager = (RecipeManager) diskOperator.
                    read("recipeManager.json", InstanceRegistry.getRecipeManager());
            InstanceRegistry.setUserManager(userManager);
            InstanceRegistry.setRecipeManager(recipeManager);
        }
        catch (IOException e) {
            System.out.println("No data found, starting with empty dataset.");
        }
        UserManager userManager = InstanceRegistry.getUserManager();
        RecipeManager recipeManager = InstanceRegistry.getRecipeManager();
        Shell shell = InstanceRegistry.getShell();
        Scanner in = new Scanner(System.in);
        while (shell.isRunning()) {
            System.out.print("$ ");
            String commandLine = in.nextLine();
            run(commandLine);
        }
        System.out.println("Bye");
        diskOperator.save("userManager.json", userManager);
        diskOperator.save("recipeManager.json", recipeManager);
    }

    public static void run(String commandLine){
        Token token = new Token(commandLine);
        CommandFactory factory = new CommandFactory(token);
        Command command = factory.getCommand();
        command.run(commandLine);
    }

}
