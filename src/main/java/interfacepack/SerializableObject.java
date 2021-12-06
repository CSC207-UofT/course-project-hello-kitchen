package interfacepack;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class SerializableObject implements Serializable {
    @Override
    public HashMap<String, Object> serialize() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(this, HashMap.class);
    }

    @Override
    public Serializable deserialize(HashMap<String, Object> record) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(record, this.getClass());
    }
}
