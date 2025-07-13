public class ActionCard extends Card {
    public enum ActionType {
        DRAW_TWO,
        REVERSE,
        SKIP
    }

    private ActionType type;

    public ActionCard(String color, ActionType type){
        super(color);
        this.type = type;
    }

    public ActionType getType() {
        return type;
    }

    @Override
    public boolean canPlay(Card topCard) {
        // Can play on if the top card has the same color
        // or if the top card is the same type as this card
        // or when the card on deck is a wild card
        return this.color.equals(topCard.getColor()) ||
                (topCard instanceof WildCard) ||
                (topCard instanceof ActionCard && ((ActionCard) topCard).type == this.type);
    }

    @Override
    public String toString() {
        return color + " " + type;
    }

}
