public abstract class Card {
    protected String color; // red, green, blue, yellow, wilcard or blank

    public Card(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canPlay(Card topCard);

    public abstract String toString();
}
