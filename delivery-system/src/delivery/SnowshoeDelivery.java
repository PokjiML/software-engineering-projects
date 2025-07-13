package delivery;

public class SnowshoeDelivery implements DeliveryStrategy {
    @Override
    public String deliver(String item, String address) {
        return "Snowshoe Hare Bunny";
    }
}
