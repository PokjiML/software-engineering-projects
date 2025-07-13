package gift;

public class GiftFacade {
    private final BookFactory bookFactory;
    private final GadgetFactory gadgetFactory;

    public GiftFacade() {
        this.bookFactory = new BookFactory();
        this.gadgetFactory = new GadgetFactory();
    }

    public Gift createGift(String name, String type) {
        switch (type.toLowerCase()) {
            case "book":
                // For now use default values
                String genre = "Fantasy";
                String author = "G.R.R. Martin";
                String title = "A Song of Ice and Fire";
                return bookFactory.createGift(name, type, genre, author, title);

            case "gadget":
                // For now use default values
                double cost = 19.99;
                return gadgetFactory.createGift(name, type, cost);

            default:
                throw new IllegalArgumentException("Unknown gift type " + type);
        }
    }
}
