package controller;
import java.util.ArrayList;
import java.util.Random;

/**
 * Blackjack class
 * core game functionality
 */
public class Blackjack {
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    /**
     * Blackjack constructor
     */
    public Blackjack() {
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    /**
     * addCardToPlayer function
     * adds a card object to the playerHand list
     * @param card
     */
    public void addCardToPlayer(Card card) {
        playerHand.add(card);
    }

    /**
     * addCardToDealer function
     * adds a card object ot the dealerHand list
     * @param card
     */
    public void addCardToDealer(Card card) {
        dealerHand.add(card);
    }

    /**
     * getPlayerHand
     * @return
     */
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    /**
     * getDealerHand
     * @return
     */
    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    /**
     * getPlayerTotal
     * @return an int, the total for the player's hand
     */
    public int getPlayerTotal() {
        return calculateHandTotal(playerHand);
    }

    /**
     * getDealerTotal
     * @return an int, the total for the dealer's hand
     */
    public int getDealerTotal() {
        return calculateHandTotal(dealerHand);
    }

    /**
     * calculateHandTotal
     * calculates the total for the passed hand based on the card numbers in the hand
     * @param hand players or dealers
     * @return an int, total
     */
    public int calculateHandTotal(ArrayList<Card> hand) {
        int total = 0;
        int aceCount = 0;

        //card number interpretation
        for (Card card : hand) {
            String number = card.getNumber();
            //number cards
            if (isNumeric(number)) {
                total += Integer.parseInt(number);
            }
            //face cards
            else if (number.equals("J") || number.equals("Q") || number.equals("K")) {
                total += 10;
            }
            //ace cards
            else if (number.equals("A")) {
                aceCount++;
                total += 11;
            }
        }
        //if total is over 21 and there's an ace, the ace will count as 1 instead of 11
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    /**
     * isNumeric
     * checks if the card number is a number (not face)
     * @param str the card number
     * @return bool
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * drawCard function
     * draws a random card from the deck
     * @return a Card object
     */
    public Card drawCard() {
        // Randomly select a suit
        char[] suits = {'H', 'D', 'C', 'S'};
        char suit = suits[new Random().nextInt(4)];

        // Randomly select a card number
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String number = numbers[new Random().nextInt(13)];

        return new Card(suit, number);
    }

}
