package DiskIO;
import java.util.HashMap;

public interface Serializable {
    public HashMap serialize();

    public void deserialize(HashMap raw);
}

