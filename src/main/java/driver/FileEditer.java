package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileEditer {
    protected File file;

    public FileEditer(String name) throws IOException {
        try {
            file = new File("name");
            if (file.createNewFile()) {
                System.out.println("Used for the first time, initializing");
            } else {
                System.out.println("Welcome to use Hello Kitchen!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
