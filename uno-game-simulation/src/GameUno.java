import java.util.*;

public class GameUno {
    private List<Player> players = new ArrayList<>();
    private int currentPlayer = 0; // Index of the current player
    private Deck deck = new Deck();
    private List<Card> pile = new ArrayList<>(); // Pile of the cards on the table
    private int direction = 1; // 1 clockwise, -1 counter-clockwise

    public GameUno() {
        for (int i = 1; i <= 4; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void start() {
        // Deal 7 cards to each player
        for (Player player : players) {
            player.drawCards(deck, pile, 7);
        }

        // Ensure the first card isn't special card
        Card firstCard;
        do {
            firstCard = deck.draw();
        } while (firstCard instanceof ActionCard || firstCard instanceof WildCard);
        pile.add(deck.draw()); // Draw the first card to start

        System.out.println("Starting card: " + pile.getFirst());


        // Main game loop
        while (true) {
            Player player = players.get(currentPlayer);
            System.out.println("\n" + player.getName() + "'s turn  " + "He has " + player.getHandSize() + " cards left");

            Card topCard = pile.getLast();
            boolean played = player.playCard(topCard, pile);

            Card playedCard = pile.getLast(); // update the top card in case the card was played

            if (!played) {
                System.out.println(player.getName() + " draws a card");
                player.drawCard(deck, pile);
            } else {
                applyCardEffect(playedCard);
            }

            if (player.hasWon()) {
                System.out.println("\nHooray " + player.getName() + " wins!");
                break;
            }

            advanceTurn();
        }
    }

    private void applyCardEffect(Card card) {
        if (card instanceof ActionCard) {
            ActionCard action = (ActionCard) card;
            switch (action.getType()) {
                case DRAW_TWO:
                    int nextPlayerIndex = (currentPlayer + direction + players.size()) % players.size();
                    Player nextPlayer = players.get(nextPlayerIndex);
                    nextPlayer.drawCards(deck, pile, 2);
                    System.out.println(nextPlayer.getName() + " draws two cards");
                    advanceTurn();
                    break;
                case REVERSE:
                    direction *= -1;
                    System.out.println("Direction reversed");
                    break;
                case SKIP:
                    System.out.println("Skipping next player");
                    advanceTurn();
                    break;
            }
        } else if (card instanceof WildCard) {
            WildCard wild = (WildCard) card;

            // If the card is DRAW FOUR
            if (wild.getType() == WildCard.WildType.DRAW_FOUR) {
                int nextPlayerIndex = (currentPlayer + direction + players.size()) % players.size();
                Player nextPlayer = players.get(nextPlayerIndex);
                nextPlayer.drawCards(deck, pile, 4);
                System.out.println(nextPlayer.getName() + " draws 4 cards");
                advanceTurn();
            }

            if (wild.getType() == WildCard.WildType.CHOOSE_COLOR) {
                // Skip turn (assume the player chooses a color the next person can't play)
                advanceTurn();
            }

        }
    }

    private void advanceTurn() {
        currentPlayer = (currentPlayer + direction + players.size()) % players.size();
    }



    public static void main(String[] args) {
        GameUno game = new GameUno();
        game.start();
    }

}
