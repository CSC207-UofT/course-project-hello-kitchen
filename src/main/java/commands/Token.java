package commands;

public class Token {

    public String type;
    public String body;

    public Token(String rawArgs) {
        String[] args = rawArgs.split(":");
        this.type = args[0];
        this.body = args[1];
    }
}
