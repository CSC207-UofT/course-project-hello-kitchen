package diskoperator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class DiskOperator {
    public String folderName;
    private ObjectMapper mapper;

    public DiskOperator() {
        this("storage");
    }

    public DiskOperator(String folderName) {
        this.folderName = folderName;
        this.mapper = new ObjectMapper();
        this.createFolderIfNotExist();
    }

    private void createFolderIfNotExist() {
        if (!(Files.exists(Paths.get(this.folderName)))) {
            new File(this.folderName).mkdir();
        }
    }

    public Path getPath(String filename) {
        return Paths.get(this.folderName, filename);
    }

    public void save(String filename, Serializable object) throws IOException {
        HashMap<String, Object> map = object.serialize();
        if (map == null){
            throw new Error(
                    "Invalid object " + object + " to save."
            );
        }
        File file = getPath(filename).toFile();
        this.mapper.writeValue(file, map);
    }

    public Serializable read(String filename, Serializable object) throws IOException {
        File file = getPath(filename).toFile();
        if(file.length() == 0){
            throw new Error("Nothing can be read from this file");
        }
        HashMap<String, Object> map = this.mapper.readValue(file, HashMap.class);
        return object.deserialize(map);
    }
}
