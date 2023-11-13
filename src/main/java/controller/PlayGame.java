package controller;

import java.util.ArrayList;

/**
 * PlayGame class
 * simulates the playing of a blackjack game
 */
public class PlayGame {

    Deck deck;
    Blackjack game;
    int gameOutcome = 0;
    double bet = 0.00;
    double payout = 0.00;
    Boolean isPlayersTurn = false;
    Boolean isDealerTurn = false;

    public void setIsPlayersTurn(Boolean isPlayersTurn){this.isPlayersTurn=isPlayersTurn;}
    public Boolean getIsPlayersTurn(){return isPlayersTurn;}

    public void setIsDealerTurn(Boolean isDealerTurn){this.isDealerTurn=isDealerTurn;}
    public Boolean getIsDealerTurn(){return isDealerTurn;}

    public void setGame(Blackjack game){
        this.game = game;
    }
    public void setDeck(Deck deck){
        this.deck = deck;
    }

    /**
     * default constructor
     */
    public PlayGame() {
        deck = new Deck();
        game = new Blackjack();
    }


/*
    public int getGameOutcome(){
        return gameOutcome;
    }*/

    /**
     * play method
     * main play progression function
     */
    public void play() {
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


    public void playerTurn() {
        game.addCardToPlayer(deck.drawCard());
    }

    /**
     * dealerTurn
     * will keep hitting until total is 17+
     */
    /*public void dealerTurn() {
        while (game.calculateHandTotal(game.getDealerHand()) < 17) {
            game.addCardToDealer(deck.drawCard());
            printHand("dealer");
        }
    }*/
    public void dealerTurn(){game.addCardToDealer(deck.drawCard());}


    /**
     * setBet
     * updates bet, used for initial bet
     */
    public void setBet(double amount){bet = amount;}

    public double getBet(){return bet;} //returns how much is currently at stake

    /**
     * calcPayOut
     * calculates how much player should be paid after game depending on outcome
     */
    public void calcPayOut(){
        if(gameOutcome==1){ //tie
            payout=bet; //get money back
        }else if(gameOutcome==2){//player win
            payout=bet*2; //1:1 win
        }else if(gameOutcome==3){//dealer win
            payout=0; //lose buy in
        }else{
            payout=bet; //something went wrong, just return buy in
        }
    }

    public double getPayout(){return payout;} //returns how much the player gets back after game


    /**
     * determineWinner
     * checks both player and dealer hand totals and determines the winner
     */
    public int determineWinner() {
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
        return gameOutcome;
//        System.out.println("end: " + gameOutcome);
    }

//    /**
//     * endGame
//     * prints who won and will add game to history
//     * @param winner int for who won (1=tie, 2=player, 3=dealer)
//     */
//    public void endGame(int winner){
//        System.out.println("Game Over!");
//        System.out.println("You: " + game.getPlayerTotal() + " Dealer: " + game.getDealerTotal());
//        if (winner == 1){
//            System.out.println("It's a tie!");
//            //add tie to user history
//        }
//        if (winner == 2){
//            System.out.println("Player wins!");
//            //add win to user history
//        }
//        if (winner == 3){
//            System.out.println("Dealer wins!");
//            //add loss to user history
//        }
//    }*/

    public void clearHands() {
        if (!game.getPlayerHand().isEmpty() || !game.getDealerHand().isEmpty()) {
            game.getDealerHand().clear();
            game.getPlayerHand().clear();
        }
    }


    public int dealerFirstCardValue() {
        Card firstCard = getDealerHand().get(0);
        String number = firstCard.getNumber();

        int cardValue;
        if (number.equals("K") || number.equals("Q") || number.equals("J")) {
            cardValue = 10;
        }
        else if(number.equals("A")){
            cardValue = 11;
        }

        else {
            cardValue = Integer.parseInt(number);
        }

        return cardValue;
    }

    /**
     * printHand
     * prints the cards in the hand and its total
     */
   /* public void printHand(String hand) {
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
    }*/
}