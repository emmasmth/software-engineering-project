package controller;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private ShuffleDeck deck = new ShuffleDeck();
    public Deck() {
        cards = new ArrayList<>();

        char[] suits = {'H', 'D', 'C', 'S'};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (char suit : suits) {
            for (String value : values) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }

    }

    private void shuffleDeck() {
        deck.shuffleDeck(cards);
    }

    public ArrayList<Card> getCards(){
        return cards;
    }



    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}
