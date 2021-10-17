package entities.user;

import java.util.ArrayList;
import entities.recipe.Recipe;

public abstract class User{
    protected String username;
    protected String password;
    protected ArrayList<Recipe> bookmark;

    public User() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
