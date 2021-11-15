package user;

import java.io.Serializable;

public abstract class User implements Serializable{
    protected String usertype;
    protected String username;
    protected String description;

    public User(String usertype, String username, String description) {
        this.usertype = usertype;
        this.username = username;
        this.description = description;
    }

    public String getUserType() {
        return this.usertype;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
