package controller;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {


    @Test public void emptyDeckTest(){
        Deck deck = new Deck();
        assertNull(deck.cards);
    }

    @Test public void nonemptyDeckTest(){
        Deck deck = new Deck();
        deck.initializeDeck();
        assertNotNull(deck.cards);
    }

    @Test public void testShuffleDeck() {
        Deck deck = new Deck();
        deck.initializeDeck();

        ArrayList<Card> deck1 = new ArrayList<>(deck.cards);

        deck.shuffleDeck(deck.cards);

        ArrayList<Card> deck2 = new ArrayList<>(deck.cards);

        assertAll(
                () -> assertNotEquals(deck1, deck2),
                () -> assertEquals(deck1.size(), deck2.size()),
                () -> assertTrue(deck1.containsAll(deck2) && deck2.containsAll(deck1))
        );
    }
    @Test public void testEmptyDeck(){
        Deck deck = new Deck();
        assertNull(deck.cards);
    }

    @Test public void testDrawCardIfEmpty(){
        Deck deck = new Deck();
        deck.drawCard();
        assertNotNull(deck.cards);
    }

}
