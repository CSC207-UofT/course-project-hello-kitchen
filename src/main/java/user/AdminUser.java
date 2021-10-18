package user;

public class AdminUser extends User{

    public AdminUser(String name){
        super.setUsertype("Admin");
        super.setUserName(name);
    }

    public AdminUser() {
        super.setUsertype("Admin");
    }
}
