package commands;

import manager.UserManager;

import java.util.ArrayList;
import java.util.HashMap;

public class DeleteUserCommand extends UserCommand{
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;

    public DeleteUserCommand(String commandBody, UserManager userManager) {
        super(commandBody, userManager);
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = commandBody.split("&");
        for (String valuePair : valuePairs) {
            this.valuePairs.add(new ValuePair(valuePair));
        }
    }

    public void execute() {
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.userManager.removeUser(Integer.parseInt(map.get("id")));
    }
}
