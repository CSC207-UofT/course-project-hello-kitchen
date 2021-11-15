package Database;

import manager.UserManager;

import java.io.*;

public class Userdata implements Datasaver {

    private UserManager userlist = new UserManager();


    public String readData() {
        String output;
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.userlist = (UserManager) in.readObject();
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
            out.writeObject(this.userlist);
            out.close();
            fileOut.close();
            return "Data has been saved successfully.";
        } catch (IOException i) {
            return "Data has not been saved successfully. Sorry, your data is lost.";
        }
    }
}