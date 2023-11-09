package controller;

import java.util.ArrayList;

public class Game {
    int gameOutcome = 0; // flag for game outcome
    Deck deck;
    Blackjack game;

    public Game() {
        deck = new Deck();
        game = new Blackjack();
    }



    public void play() {
       dealInitialCards();
    }

    public void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            game.addCardToPlayer(deck.drawCard());
            game.addCardToDealer(deck.drawCard());
        }
    }

    public ArrayList<Card> getDealerHand() {
        return game.getDealerHand();
    }
    public ArrayList<Card> getPlayerHand() {
        return game.getPlayerHand();
    }


}
