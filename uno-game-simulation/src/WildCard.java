public class WildCard extends Card {
    public enum WildType {
        DRAW_FOUR,
        CHOOSE_COLOR
    }

    private WildType type;

    public WildCard(WildType type) {
        super(null);
        this.type = type;
    }

    public WildType getType() {
        return type;
    }

    @Override
    public boolean canPlay(Card topCard) {
        return true;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
