package user;

public abstract class User{
    String name;
    String description;

    public User(String name, String description){
        this.name = name;
        this.description = description;
    }

    public abstract String getName();

    public abstract String toString();
}
