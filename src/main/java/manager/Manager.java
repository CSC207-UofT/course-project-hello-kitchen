package manager;

import java.util.HashMap;

public abstract class Manager<T> {
    protected HashMap<String, T> database;

    public Manager(){
        database = new HashMap<>();
    }

    public void addObject(String name, T obj){
        database.put(name, obj);
    }

    public void removeObject(String name){
        database.remove(name);
    }

    public T getObject(String name){
        return database.get(name);
    }
}
