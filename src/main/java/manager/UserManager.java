package manager;

import user.User;

import java.util.HashMap;


public class UserManager {
    private HashMap<String, User> users;
    private int counter;
    private User currentUser;

    public UserManager() {
        this.users = new HashMap<>();
        this.counter = 0;
    }

    public void createUser(String name, String password, String description) {
        /* The private attribute counter will be responsible for assigning ids for users
         * Every time a new user is created, the value of the counter will be assigned to the user as id
         * Afterwards, the counter will add one for the next incoming user
         * The counter's current value will also be stored when writing data
         */
        int id = this.counter;
        User user = new User(name, password, description, id);
        users.put(name, user);
        this.counter += 1;
        System.out.println("Create user successful, name:" + user.name + "id:" + user.id +
                " description:" + user.description);
    }

    public boolean removeUser(int id) {
        for(User user: this.users.values()) {
            if(id == user.id) {
                this.users.remove(user);
                System.out.println("Remove user successful, name:"+ user.name);
                return true;
            }
        }
        System.out.println("Remove user failed.");
        return false;
    }

    public String listUser() {
        StringBuilder list = new StringBuilder();
        for(User user: this.users.values()) {
            list.append("Username:").append(user.name).append("id:").append(user.id).append("\n");
        }
        return list.toString();
    }

    public void signIn(String name, String password) {
        if(!(this.users.containsKey(name))) {
            throw new Error("Invalid username or password.");
        }
        User user = this.users.get(name);
        if(!(user.password.equals(password))) {
            throw new Error("Invalid username or password.");
        }
        this.currentUser = user;
        System.out.println("Sign in Successful.");
    }

    public void signOut() {
        this.currentUser = null;
        System.out.println("Signed out.");
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public User[] getUserList() {
        return this.users.values().toArray(new User[0]);
    }

}
