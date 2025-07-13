package gift;

public class GadgetFactory {

    public Gift createGift(String name, String type, double cost) {
        return new Gadget(name, type, cost);
    }
}
