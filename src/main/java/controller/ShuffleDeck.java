package controller;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleDeck {
    Deck deck = new Deck();

    public void setDeck(Deck deck){
        this.deck = deck;
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
}
