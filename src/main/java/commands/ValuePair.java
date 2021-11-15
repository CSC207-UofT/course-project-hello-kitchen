package commands;

public class ValuePair {

    public String field;
    public String value;

    public ValuePair (String rawValuePair) {
        String[] valuePair = rawValuePair.split("=");
        this.field = valuePair[0];
        this.value = valuePair[1];
    }
}
