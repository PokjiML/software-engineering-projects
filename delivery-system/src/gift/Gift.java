package gift;

public abstract class Gift {
    private String name;
    private String type;

    public Gift(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }


}
