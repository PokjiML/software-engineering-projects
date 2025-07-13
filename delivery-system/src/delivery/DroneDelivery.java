package delivery;

public class DroneDelivery implements DeliveryStrategy {
    @Override
    public String deliver(String item, String address) {
        return "Drone";
    }
}
