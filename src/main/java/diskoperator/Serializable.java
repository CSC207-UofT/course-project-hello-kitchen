package diskoperator;

import java.util.HashMap;

public interface Serializable {
    HashMap<String, Object> serialize();
    Serializable deserialize(HashMap<String, Object> record);
}

