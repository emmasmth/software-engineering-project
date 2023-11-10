package controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * PlayGame class
 * simulates the playing of a blackjack game
 */
public class PlayGame {

    int gameOutcome = 0;
    Deck deck;
    Blackjack game;
    ShuffleDeck shuffleDeck;
    private boolean deckShuffled = false;

    /**
     * default constructor
     */
    public PlayGame() {
        deck = new Deck();
        game = new Blackjack();
        shuffleDeck = new ShuffleDeck();
    }



    public int getGameOutcome(){
        return gameOutcome;
    }

    /**
     * play method
     * main play progression function
     */
    public void play() {
        if (!deckShuffled) {
            shuffleDeck.shuffleDeck(deck.getCards());
            deckShuffled = true;
        }
        // Deal initial cards
        dealInitialCards();

        // Check for naturals
        checkNaturals();


    }

    /**
     * dealInitialCards
     * adds first 2 cards to dealer and player hands
     */
    public void dealInitialCards() {
        //deal two cards to player and dealer
        for (int i = 0; i < 2; i++) {
            game.addCardToPlayer(deck.drawCard());
            game.addCardToDealer(deck.drawCard());
        }
        //shows each hand
        printHand("player");
        System.out.println("Dealer's visible card: " + game.getDealerHand().get(0));
    }

    /**
     * checkNaturals
     * checks if player or dealer won with initial cards
     */
    public void checkNaturals() {
        if(game.getPlayerTotal() == 21 && game.getDealerTotal()==21){
            gameOutcome = 1; //tie
        }
        else if (game.getPlayerTotal() == 21) {
            gameOutcome = 2; //player win
        }
        else if (game.getDealerTotal() == 21) {
            gameOutcome = 3; //dealer win
        }
        else
            gameOutcome = 0; //neither - continue game
    }
    public ArrayList<Card> getDealerHand() {
        return game.getDealerHand();
    }

    public ArrayList<Card> getPlayerHand() {
        return game.getPlayerHand();
    }



    public int playerTotal(){
        return game.getPlayerTotal();
    }
    public int dealerTotal(){
        return game.getDealerTotal();
    }


    public int playerTurn() {
        game.addCardToPlayer(deck.drawCard());
        return(0);
    }

    /**
     * dealerTurn
     * will keep hitting until total is 17+
     */
    public void dealerTurn() {
        while (game.calculateHandTotal(game.getDealerHand()) < 17) {
            game.addCardToDealer(deck.drawCard());
            printHand("dealer");
        }
    }

    /**
     * determineWinner
     * checks both player and dealer hand totals and determines the winner
     */
    public void determineWinner() {
        int playerTotal = game.calculateHandTotal(game.getPlayerHand());
        int dealerTotal = game.calculateHandTotal(game.getDealerHand());
        System.out.println("player: " + playerTotal);
        System.out.println("dealer: " + dealerTotal);
        if (playerTotal > 21 || (dealerTotal <= 21 && dealerTotal > playerTotal)) {
            gameOutcome = 3; // dealer win
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            gameOutcome = 2; // player win
        } else {
            gameOutcome = 1; // tie
        }
        System.out.println("end: " + gameOutcome);
    }

    /**
     * endGame
     * prints who won and will add game to history
     * @param winner int for who won (1=tie, 2=player, 3=dealer)
     */
    public void endGame(int winner){
        System.out.println("Game Over!");
        System.out.println("You: " + game.getPlayerTotal() + " Dealer: " + game.getDealerTotal());
        if (winner == 1){
            System.out.println("It's a tie!");
            //add tie to user history
        }
        if (winner == 2){
            System.out.println("Player wins!");
            //add win to user history
        }
        if (winner == 3){
            System.out.println("Dealer wins!");
            //add loss to user history
        }
    }

    public void clearHands() {
        if (!game.getPlayerHand().isEmpty() || !game.getDealerHand().isEmpty()) {
            game.getDealerHand().clear();
            game.getPlayerHand().clear();
        }
    }

    /**
     * printHand
     * prints the cards in the hand and its total
     */
    public void printHand(String hand) {
        if(hand.equals("player")) {
            if (!game.getPlayerHand().isEmpty()) {
                System.out.println("Your hand: " + game.getPlayerHand() + " (" + game.getPlayerTotal() + ")");
            }
            else {
                System.out.println("Player hand is empty");
            }
        }
        else {
            if(!game.getDealerHand().isEmpty()) {
                System.out.println("Dealer hand: " + game.getDealerHand() + " (" + game.getDealerTotal() + ")");
            }
            else {
                System.out.println("Dealer hand is empty");
            }
        }
    }
}
