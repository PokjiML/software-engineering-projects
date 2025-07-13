public class NumberCard extends Card {
    private int number;

    public NumberCard(String color, int number) {
        super(color);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean canPlay(Card topCard) {
        // If the card is a wildcard
        if (topCard instanceof WildCard) {
            return true; // can play on any wild card
        }
        // If the Card in a Number card
        if (topCard instanceof NumberCard) {
            NumberCard top = (NumberCard) topCard; // cast the topCard to NumberCard
            return (this.color.equals(top.color) || (this.number == top.number));
        }
        return this.color.equals(topCard.color);
    }

    public String toString() {
        return color + " " + number;
    }


}
