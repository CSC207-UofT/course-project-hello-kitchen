package user;

import recipe.Recipe;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    public String username;
    public String password;
    public String description;
    public ArrayList<Recipe> favouriteList;

    public User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.favouriteList = new ArrayList<>();
    }

    public void addFavourite(Recipe recipe) {
        this.favouriteList.add(recipe);
    }
}
