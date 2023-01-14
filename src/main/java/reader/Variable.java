package reader;

public class Variable {
    private String name;
    private String value;
    Variable(String name, String value) {
        this.name = name;
        this.value = value;
    }

    String getName() {
        return name;
    }

    String getValue() {
        return value;
    }
    public void print() {
        System.out.println("Name: " + name + " Value: " + value);
    }
}