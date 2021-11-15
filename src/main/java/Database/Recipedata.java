package Database;



import manager.RecipeManager;
import recipe.Recipe;

import java.io.*;

public class Recipedata implements Datasaver {

    private RecipeManager recipelist = new RecipeManager();

    public String readData() {
        String output;
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.recipelist = (RecipeManager) in.readObject();
            in.close();
            fileIn.close();
            output = "Data has been loaded successfully.";
        } catch (IOException i) {
            output = "Data not found. We are starting with a new empty system.";
        } catch (ClassNotFoundException c) {
            output = "UserList class not found. We are starting with a new empty system.";
        }
        return output;
    }

    @Override
    public String writeData() {
        try {
            FileOutputStream fileOut = new FileOutputStream(systemFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.recipelist);
            out.close();
            fileOut.close();
            return "Data has been saved successfully.";
        } catch (IOException i) {
            return "Data has not been saved successfully. Sorry, your data is lost.";
        }
    }
}