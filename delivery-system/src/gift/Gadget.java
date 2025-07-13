package gift;

public class Gadget extends Gift {
    private double cost;

    public Gadget(String name, String type, double cost) {
        super(name + "(Gadget)", "Gadget");
        this.cost = cost;
    }


    public double getCost() {
        return cost;
    }
}
