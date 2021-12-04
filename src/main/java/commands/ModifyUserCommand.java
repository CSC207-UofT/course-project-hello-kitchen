package commands;

import manager.UserManager;
import user.User;

import java.util.*;

public class ModifyUserCommand extends UserCommand{
    public ArrayList<ValuePair> valuePairs;
    public UserManager userManager;
    private static final HashSet<String> acceptArgs = new HashSet<String>() {{
        add("username");
        add("field");
    }};

    public ModifyUserCommand() {}

    /**
     * Parse the `commandLine` according to usage template and execute command after parsing.
     * @param commandLine The `commandLine` to be processed.
     */
    @Override
    public void run(String commandLine) {
        Token token = new Token(commandLine);
        this.valuePairs = new ArrayList<>();
        String[] valuePairs = token.body.split("&");
        for(String rawValuePair: valuePairs) {
            ValuePair valuePair = new ValuePair(rawValuePair);
            if (!this.acceptArgs.contains(valuePair.field)) {
                throw new Error("Invalid user command");
            }
            this.valuePairs.add(valuePair);
        }
        this.execute();
    }

    /**
     * Execute the command.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        for (ValuePair valuePair: this.valuePairs) {
            map.put(valuePair.field, valuePair.value);
        }
        this.userManager = userManager.getInstance();
        User user = this.userManager.getUser(map.get("username"));
        if(Objects.equals(map.get("field"), "password")) {
            System.out.println("Please enter your new password:");
            user.password = scanner.nextLine();
        }
        if (Objects.equals(map.get("field"), "description")) {
            System.out.println("Please enter your new description:");
            user.description = scanner.nextLine();
        }
    }

}
