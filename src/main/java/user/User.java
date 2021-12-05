package user;

import interfacepack.Serializable;
import recipe.Recipe;


import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {
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

    @Override
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", this.username);
        return map;
    }

    @Override
    public void deserialize(HashMap<String, Object> record) {
        this.username = (String) record.get("username");
    }
}
