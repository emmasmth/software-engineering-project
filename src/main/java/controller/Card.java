package controller;

public class Card {
    private char suit;   // 'H', 'C', 'S', 'D'
    private char number; // '1' to '10', 'J', 'Q', 'K'

    public Card(char suit, char number) {
        this.suit = suit;
        this.number = number;
    }

    public char getSuit() {
        return suit;
    }

    public char getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number) + suit;
    }
}
