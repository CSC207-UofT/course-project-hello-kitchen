package DiskIO;

import java.io.*;
import java.util.HashMap;

public class DiskOperator {


    private DiskOperator() {
    }


    public String readData(String filename, Serializable model) {
        String output;
        HashMap<String, String>  dataRec = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dataRec = (HashMap<String, String>) in.readObject();
            in.close();
            fileIn.close();
            output = "Data has been loaded successfully.";
        } catch (IOException i) {
            output = "Data not found. We are starting with a new empty system.";
        } catch (ClassNotFoundException c) {
            output = "UserList class not found. We are starting with a new empty system.";
        }
        model.deserialize(dataRec);
        return output;
    }

    public String writeData(String filename, Serializable model) {
        HashMap dataToSave = model.serialize();
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dataToSave);
            out.close();
            fileOut.close();
            return "Data has been saved successfully.";
        } catch (IOException i) {
            return "Data has not been saved successfully. Sorry, your data is lost.";
        }
    }
}