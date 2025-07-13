import java.util.*;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck, List<Card> pile) {
        // Call the safeDraw method on the deck instance
        hand.add(deck.safeDraw(pile));
    }

    public void drawCards(Deck deck, List<Card> pile, int count) {
        // Draw N number of cards from the Deck
        for (int i = 0; i < count; i++) {
            drawCard(deck, pile);
        }
    }

    public boolean playCard(Card topCard, List<Card> pile) {
        for (Card card : hand) {
            if (card.canPlay(topCard)) {
                hand.remove(card);
                pile.add(card);
                System.out.println(name + " played " + card);
                return true;
            }
        }
        return false;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.size();
    }


}
