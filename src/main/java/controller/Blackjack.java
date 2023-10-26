package controller;
import java.util.ArrayList;
public class Blackjack {
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

        //create player's and dealer's hands
        public Blackjack() {
            playerHand = new ArrayList<>();
            dealerHand = new ArrayList<>();
        }

    public void addCardToPlayer(Card card) {
        playerHand.add(card);
    }

    public void addCardToDealer(Card card) {
        dealerHand.add(card);
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public int getPlayerTotal() {
        return calculateHandTotal(playerHand);
    }

    public int getDealerTotal() {
        return calculateHandTotal(dealerHand);
    }

    //calculate the passed hands point total
    public static int calculateHandTotal(ArrayList<Card> hand) {
        int total = 0;
        int aceCount = 0;

        //card number interpretation
        for (Card card : hand) {
            char number = card.getNumber();
            if (Character.isDigit(number)) {
                total += Character.getNumericValue(number);
            } else if (number == 'j' || number == 'q' || number == 'k') {
                total += 10;
            } else if (number == 'a') {
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
}
