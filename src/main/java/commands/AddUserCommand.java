package commands;

import manager.UserManager;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class AddUserCommand extends UserCommand {
    public String commandBody;
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;

    public AddUserCommand(String commandBody, UserManager userManager) {
        super(commandBody, userManager);
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = commandBody.split("&");
        for (String valuePair: valuePairs) {
            this.valuePairs.add(new ValuePair(valuePair));
        }
    }

    public void execute() {
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        User user = new User(map.get("name"), map.get("password"), map.get("description"));
        this.userManager.register(user);
    }
}
