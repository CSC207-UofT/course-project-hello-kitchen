package commands;

public class Token {

    public String root;
    public String type;
    public String body;

    public Token(String rawArgs) {
        String root = rawArgs.split(" ")[0];
        String[] args = rawArgs.split(":");
        this.root = root;
        this.type = args[0].replace(root + " ", "");
        if(args.length <2) {
            this.body = "";
        }
        else {
            this.body = args[1];
        }
    }
}
