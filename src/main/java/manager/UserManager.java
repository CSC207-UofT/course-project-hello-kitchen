package manager;

import recipe.Recipe;
import user.User;

import java.util.HashMap;


public class UserManager extends Manager {
    private HashMap<String, User> users;
    private User currentUser;
    private static UserManager instance;

    private UserManager() {
        this.users = new HashMap<>();
    }

    /**
     * Register `user` to the manager, ensuring the registered username is unique.
     * @param user User to manage.
     */
    public void register(User user) {
        for(String username: this.users.keySet()){
            if(username.equals(user.username)) {
                throw new Error("Username occupied, change another name");
            }
        }
        users.put(user.username, user);
        System.out.println("Create user successful, name:" + user.username +
                " description:" + user.description);
    }

    /**
     * Remove user with `name`.
     * @param username The `name` of the user.
     */
    public void removeUser(String username) {
        if(!(this.users.containsKey(username))) {
            throw new Error("User does not exist.");
        }
        users.remove(username);
        System.out.println("Remove successful, username:" + username);
    }

    /**
     * Sign a user in with `username` and `password`.
     * @param username The `username` of the user trying to log in.
     * @param password The `password` of the user trying to log in.
     */
    public void signIn(String username, String password) {
        if(!(this.users.containsKey(username))) {
            throw new Error("Invalid username or password.");
        }
        User user = this.users.get(username);
        if(!(user.password.equals(password))) {
            throw new Error("Invalid username or password.");
        }
        this.currentUser = user;
        System.out.println("Sign in Successful.");
    }

    /**
     * Sign out current user from the manager.
     */
    public void signOut() {
        this.currentUser = null;
        System.out.println("Signed out.");
    }

    /**
     * Get current user.
     * @return The current user instance.
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * Get user with `username`.
     * @param username The `username` of the desired user.
     * @return The user with `username`.
     */
    public User getUser(String username) {
        return this.users.get(username);
    }

    /**
     * Get user list.
     * @return The list of all users in the manager.
     */
    public User[] getUserList() {
        return this.users.values().toArray(new User[0]);
    }

    public void favourite(Recipe recipe) {
        if(this.currentUser == null) {
            throw new Error("You need to sign in to user this feature.");
        }
        this.currentUser.addFavourite(recipe);
    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

}
