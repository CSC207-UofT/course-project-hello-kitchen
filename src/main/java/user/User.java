package user;

import recipe.Recipe;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    public String name;
    public String password;
    public String description;
    public int id;
    public ArrayList<Recipe> favouriteList;

    public User(String name, String password, String description, int id) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.id = id;
        this.favouriteList = new ArrayList<>();
    }

    public void addFavourite(Recipe recipe) {
        this.favouriteList.add(recipe);
    }
}
