package delivery;

public class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setStrategy(String location) {
        switch (location.toLowerCase()) {
            case "snowy":
                this.strategy = new SnowshoeDelivery();
                break;
            case "coastal":
                this.strategy = new BoatStrategy();
                break;
            case "urban":
                this.strategy = new DroneDelivery();
                break;
            default:
                this.strategy = null;
        }
    }

    public String deliver(String item, String address) {
        if (this.strategy == null) {
            throw new IllegalArgumentException("No delivery strategy set for this location.");
        }
        return this.strategy.deliver(item, address);
    }
}
