package controller;

import java.util.ArrayList;

public class Game {
    int gameOutcome = 0;
    Deck deck;
    Blackjack game;
    ShuffleDeck shuffleDeck;
    private boolean deckShuffled = false;


    public Game() {
        deck = new Deck();
        game = new Blackjack();
        shuffleDeck = new ShuffleDeck();
    }

    public void play() {
        if (!deckShuffled) {
            shuffleDeck.shuffleDeck(deck.getCards());
            deckShuffled = true;
        }

        dealInitialCards();
        checkNaturals();
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

    public void hit() {
            game.addCardToPlayer(deck.drawCard());
    }

    public int playerTotal(){
        return game.getPlayerTotal();
    }
    public int dealerTotal(){
        return game.getDealerTotal();
    }

    public void checkNaturals() {
        if(game.getPlayerTotal() == 21 && game.getDealerTotal()==21){
            gameOutcome = 1;
        }
        else if (game.getPlayerTotal() == 21) {
            gameOutcome = 2;
        }
        else if (game.getDealerTotal() == 21) {
            gameOutcome = 3;
        }
        else
            gameOutcome = 0;
    }

    public void clearHands() {
        if (!game.getPlayerHand().isEmpty() || !game.getDealerHand().isEmpty()) {
            game.getDealerHand().clear();
            game.getPlayerHand().clear();
        }
    }



}
