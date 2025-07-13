package delivery;

public class BoatStrategy implements DeliveryStrategy {
    @Override
    public String deliver(String item, String address) {
        return "Boat";
    }
}
