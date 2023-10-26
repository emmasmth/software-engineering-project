package controller;

/**
 * Card class
 * creates card objects with a suit and a number
 */
public class Card {
    private char suit;   // h(hearts), c(clubs), s(spades), d(diamonds)
    private String number; // 1 - 10, j(jack), q(queen), k(king)

    /**
     * card constructor
     * @param suit
     * @param number
     */
    public Card(char suit, String number) {
        this.suit = suit;
        this.number = number;
    }

    /**
     * getSuit
     * @return char, suit of card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * getNumber
     * @return char, number of card
     */
    public String getNumber() {
        return number;
    }

    /**
     * toString
     * @return string, suit and number of card
     */
    @Override
    public String toString() {
        return String.valueOf(number) + suit;
    }
}
