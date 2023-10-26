package controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CardTest {

    @Test
    public void testGetSuit1() {
        Card heartCard = new Card('H', 'J');
        assertEquals('H', heartCard.getSuit());
    }

    @Test
    public void testGetSuit2() {
        Card heartCard = new Card('S', '4');
        assertEquals('S', heartCard.getSuit());
    }

    @Test
    public void testGetNumber1() {
        Card numberCard = new Card('D', '5');
        assertEquals('5', numberCard.getNumber());
    }

    @Test
    public void testGetNumber2() {
        Card numberCard = new Card('H', 'J');
        assertEquals('J', numberCard.getNumber());
    }

    @Test
    public void testCardConstructorSuit() {
        Card card = new Card('H', '7');
        assertEquals('H', card.getSuit());
    }

    @Test
    public void testCardConstructorNumber() {
        Card card = new Card('H', '7');
        assertEquals('7', card.getNumber());
    }

    @Test
    public void testToString1() {
        Card card = new Card('H', 'K');
        assertEquals("KH", card.toString());
    }

    @Test
    public void testToString2() {
        Card card = new Card('D', '4');
        assertEquals("4D", card.toString());
    }
}
