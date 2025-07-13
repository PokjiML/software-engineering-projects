import delivery.DeliveryContext;
import gift.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No input provided.");
            return;
        }

        String[] lines = args[0].split("\\\\n");

        // Test print the values
        for (String line : args) {
            System.out.println(line);
        }


        // Create arrays for served and unserved children
        List<String> served = new ArrayList<>();
        List<String> notServed = new ArrayList<>();

        // Initialize the factories and create gifts for children
        GiftFacade giftFactory = new GiftFacade();

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(",");
            // For incomplete input
            if (parts.length != 4) {
                notServed.add(line.split(",")[0] + ": Gift - ");
                continue;
            }
            // Get the complete input variables
            String name = parts[0].trim();
            String ageStr = parts[1].trim();
            String location = parts[2].trim();
            String preference = parts[3].trim();

            Gift gift = null;
            try {
                // If preference is Book or Gadget
                if (preference.equalsIgnoreCase("book") ||
                        preference.equalsIgnoreCase("gadget")) {
                    gift = giftFactory.createGift(name, preference);
                } else {
                    notServed.add(name + ": Gift - " + preference + "?");
                    continue;
                }
            } catch (Exception e) {
                notServed.add(name + ": Gift - " + preference + "?");
                continue;
            }

            // Delivery strategy
            DeliveryContext deliveryContext = new DeliveryContext();
            deliveryContext.setStrategy(location);
            String deliveryMethod;
            try {
                deliveryMethod = deliveryContext.deliver(gift.getName(), location);
            } catch (Exception e) {
                notServed.add(name + ": Gift - " + gift.getName() + "?");
                continue;
            }

            // Format output
            String giftOutput = "";
            if (gift instanceof Book) {
                Book book = (Book) gift;
                giftOutput = book.getGenre() + " Book";
            } else if (gift instanceof Gadget) {
                giftOutput = gift.getName();
            } else {
                giftOutput = gift.getName();
            }
            served.add(name + ": Gift - " + giftOutput + ", Delivery - " + deliveryMethod);
        }
        System.out.println("Children who can be served:");
        for (String child : served) {
            System.out.println(child);
        }
        System.out.println("Children who can't be served");
        for (String child : notServed) {
            System.out.println(child);
        }


    }
}
