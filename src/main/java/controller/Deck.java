package controller;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards;


    public void initializeDeck() {
        cards = new ArrayList<>();
        char[] suits = {'H', 'D', 'C', 'S'};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (char suit : suits) {
            for (String value : values) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }

        shuffleDeck(cards);
    }

    public void shuffleDeck(ArrayList<Card> originalDeck){
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random random = new Random();
        while (!originalDeck.isEmpty()) {
            int randomIndex = random.nextInt(originalDeck.size());
            Card randomCard = originalDeck.remove(randomIndex);
            shuffledDeck.add(randomCard);
        }
        originalDeck.addAll(shuffledDeck);
    }





    public Card drawCard() {
        if (cards == null || cards.isEmpty()) {
            initializeDeck();
        }
        return cards.remove(0);
    }

}