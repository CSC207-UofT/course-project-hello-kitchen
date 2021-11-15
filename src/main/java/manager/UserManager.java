package manager;

import user.AdminUser;
import user.CommonUser;
import user.User;

import javax.lang.model.element.Element;
import java.util.*;
import java.util.ArrayList;

public class UserManager {
    //private List<User> users;

    static Hashtable<String, User> users;//key for name,value for User,User contains name,password,usertype etc

    static {
        users = new Hashtable<String, User>();
        users.put("jack", new AdminUser("jack", "123", "Administrative"));
        users.put("rose", new CommonUser("rose", "123", "User"));
    }

    public static User search(String name, String password) //If user already exists
    {
        if (users.containsKey(name)) {
            User temp = users.get(name);
            if ((temp.getPassword()).equals(password))
                return temp;
        }
        return null;
    }

//    public UserManager() {
//        users = new ArrayList<>();
//    }

    //    public void createUser(String name, String description, String password) {
//        User user = new User(name, description, password);
//        users.add(user);
//        System.out.println("Create user successful, name:" + user.getUserName() +
//                " description:" + user.getDescription());
//    }
//
//    public void createAdminUser(String name, String description) {
//        AdminUser user = new AdminUser(name, description);
//        users.add(user);
//    }
    public static boolean createUser(String name, String password, String description) {
        User user;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username");
        name = sc.next();
        System.out.println("Please enter password");
        password = sc.next();
        System.out.println("Please enter user description");
        description = sc.next();

        if (users.containsKey(name)) {
            System.out.println("username is already taken");
            sc.close();
            return false;
        }
        {
            user = new CommonUser(name, password, description);
            users.put(name, user);
            System.out.println("Success");
            sc.close();
            return true;
        }
    }

    public static boolean deleteUser (String name){//delete user
        if (users.containsKey(name)) {
            users.remove(name);
            return true;
        } else {
            return false;
        }
    }
    public static Enumeration<User> getAllUser() {//List all users
        return users.elements();
    }

    public static boolean update (String name, String password, String description){//change user's password
        User user;
        if (users.containsKey(name)) {
            user = new CommonUser(name, password, description);
            users.put(name, user);
            return true;
        } else
            return false;
    }

    public static ArrayList<String> display(String name){
        if (users.containsKey(name)) {
            User temp = users.get(name);
            ArrayList<String> ls = new ArrayList<String>();
            ls.add(temp.getUserName());
            ls.add(temp.getPassword());
            ls.add(temp.getDescription());
            return ls;
        }
        else{
            return null;
        }
    }
}



//    public List<User> getAllUsers() {
//        return users;
//    }
//}
