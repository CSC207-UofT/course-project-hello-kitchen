package interfacepack;

import java.util.HashMap;

public interface Serializable {
    HashMap<String, Object> serialize();
    void deserialize(HashMap<String, Object> record);
}

