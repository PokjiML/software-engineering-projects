import java.util.*;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    public Deck() {
        initialize();
        shuffle(); // Shuffle the deck after initializing
    }

    // Create a deck of cards
    private void initialize() {
        String[] colors = {"red", "green", "blue", "yellow"};

        for (String color : colors) {
            // go through every color

            cards.push(new NumberCard(color, 0)); // one zero

            for (int i = 1; i <= 9; i++) {
                cards.push(new NumberCard(color, i));
                cards.push(new NumberCard(color, i)); // two of each color
            }

            for (int i = 0; i < 2; i++) {
                cards.push(new ActionCard(color, ActionCard.ActionType.DRAW_TWO));
                cards.push(new ActionCard(color, ActionCard.ActionType.REVERSE));
                cards.push(new ActionCard(color, ActionCard.ActionType.DRAW_TWO));
            }
        }

        // Add Wildcards to the deck, 4 for each
        for (int i = 0; i < 4; i++) {
            cards.push(new WildCard(WildCard.WildType.DRAW_FOUR));
            cards.push(new WildCard(WildCard.WildType.CHOOSE_COLOR));
        }
    }

    public void refillFrom(List<Card> pile) {
        // Refill the deck with the cards from the pile
        if (pile.size() <= 1) {
            return; // Cannot refill with less than 2 cards
        }

        Card topCard = pile.removeLast(); // Save the top card
        cards.addAll(pile); // Add the cards from the pile to the deck
        Collections.shuffle(cards);
        pile.clear();
        pile.add(topCard); // Add the top card back to the pile

        System.out.println("Deck refilled from pile.");
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card safeDraw(List<Card> pile) {
        if (this.isEmpty()) {
            this.refillFrom(pile);
        }
        if (this.isEmpty()) { // Check again in case refill was not possible or pile was too small
            System.out.println("\nDeck is empty, cannot draw new cards.\n");
            throw new IllegalStateException("No cards can be drawn anymore");
        }
        return this.draw();
    }


}
