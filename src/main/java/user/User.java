package user;

import java.time.LocalDateTime;
import java.util.HashMap;

import recipe.Recipe;

public abstract class User{
    protected String usertype;
    protected String username;
    protected HashMap<Recipe, LocalDateTime> bookmark;

    public User() {
    }

    public String getUserType() {
        return this.usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<Recipe, LocalDateTime> getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(HashMap<Recipe, LocalDateTime> bookmark) {
        this.bookmark = bookmark;
    }

    public void addBookmark(Recipe recipe, LocalDateTime time) {
        this.bookmark.put(recipe, time);
    }
}
