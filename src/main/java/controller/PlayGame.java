package controller;
import model.entity.TryUserDatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * PlayGame class
 * simulates the playing of a blackjack game
 */
public class PlayGame {

    private Blackjack game;
    private Scanner scanner;
    private int gameOutcome = 0; //flag for game outcome

    /**
     * default constructor
     */
    public PlayGame() {
        game = new Blackjack();
        scanner = new Scanner(System.in);
    }

    /**
     * constructor for testing with mockito
     * @param game
     * @param scanner
     */
    public PlayGame(Blackjack game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }


    /**
     * main play progression function
     */
    public void play() {
        System.out.println("Welcome to Blackjack!");

        // Deal initial cards
        dealInitialCards();

        // Check for naturals
        checkNaturals();

        //if neither won yet
        if (gameOutcome == 0) {

            // Player's turn
            if (playerTurn() == 0) {

                //if player didn't bust
                // Dealer's turn
                dealerTurn();
            }

            // Determine the winner
            determineWinner();
        }

        //announce winner
        endGame(gameOutcome);

        scanner.close();
    }

    /**
     * dealInitialCards
     * adds first 2 cards to dealer and player hands
     */
    public void dealInitialCards() {
        //deal two cards to player and dealer
        for (int i = 0; i < 2; i++) {
            game.addCardToPlayer(game.drawCard());
            game.addCardToDealer(game.drawCard());
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
        //neither -> continue
    }

    /**
     * playerTurn
     * give player options to hit or stand for their turn
     * return int - 0=continue play, 1=player busted
     */
    public int playerTurn() {
        //repeat player's turn until stand or bust
        while (true) {
            System.out.println("Do you want to (h)it or (s)tand?");
            char choice = scanner.nextLine().charAt(0);

            if (choice == 'h') {
                game.addCardToPlayer(game.drawCard());
                printHand("player");
                //player got 21 - automatic move on
                if(Blackjack.calculateHandTotal(game.getPlayerHand()) == 21){
                    break;
                }
                //player busted
                if (Blackjack.calculateHandTotal(game.getPlayerHand()) > 21) {
                    System.out.println("Busted!");
                    return(1);
                }
            } else if (choice == 's') {
                break;
            }
        }
        return(0);
    }

    /**
     * dealerTurn
     * will keep hitting until total is 17+
     */
    public void dealerTurn() {
        System.out.println("Dealer's turn...");
        while (Blackjack.calculateHandTotal(game.getDealerHand()) < 17) {
            game.addCardToDealer(game.drawCard());
            printHand("dealer");
        }
    }

    /**
     * determineWinner
     * checks both player and dealer hand totals and determines the winner
     */
    public void determineWinner() {
        int playerTotal = Blackjack.calculateHandTotal(game.getPlayerHand());
        int dealerTotal = Blackjack.calculateHandTotal(game.getDealerHand());

        if (playerTotal > 21 || (dealerTotal <= 21 && dealerTotal > playerTotal)) {
            gameOutcome = 3; // dealer win
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            gameOutcome = 2; // player win
        } else {
            gameOutcome = 1; // tie
        }
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

    /**
     * printHand
     * prints the cards in the hand and its total
     */
    public void printHand(String hand) {
        if(hand.equals("player")) {
            System.out.println("Your hand: " + game.getPlayerHand() + " (" + game.getPlayerTotal() + ")");
        }
        else
            System.out.println("Dealer hand: " + game.getDealerHand() + " (" + game.getDealerTotal() + ")");
    }

    /**
     * drawCard
     * adds a random card to the hand
     * @return card
     */
//    public Card drawCard() {
//        // just return random cards.
//        // will create deck of cards in later sprint
//        char[] suits = {'H', 'C', 'S', 'D'};
//        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//        char suit = suits[(int) (Math.random() * 4)];
//        String number = numbers[(int) (Math.random() * 13)];
//        return new Card(suit, number);
//    }



    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.play();

        // TryUserDatabase tud = new TryUserDatabase(); // ** Was using this to test if database is working
    }
}
