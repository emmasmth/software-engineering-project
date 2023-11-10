package controller;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleDeck {


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
