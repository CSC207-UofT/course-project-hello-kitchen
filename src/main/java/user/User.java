package user;

import interfacepack.Serializable;
import interfacepack.SerializableObject;
import recipe.Recipe;


import java.util.ArrayList;
import java.util.HashMap;

public class User extends SerializableObject {
    public String username;
    public String password;
    public String description;
    public ArrayList<Recipe> favouriteList;

    public User() {}

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
