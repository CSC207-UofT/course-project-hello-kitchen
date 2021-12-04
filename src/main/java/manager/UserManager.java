package manager;

import user.User;

import java.util.HashMap;


public class UserManager {
    private HashMap<String, User> users;
    private User currentUser;
    private static UserManager instance;

    private UserManager() {
        this.users = new HashMap<>();
    }

    /**
     * Register `user` to the manager.
     * @param user User to manage.
     */
    public void register(User user) {
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
     * Get user list.
     * @return The list of all users in the manager.
     */
    public User[] getUserList() {
        return this.users.values().toArray(new User[0]);
    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

}
