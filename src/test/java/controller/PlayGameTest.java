package controller;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGameTest {
// New tests setup without the use of Scanner




    @Test public void dealInitialCardsTest(){
        Deck deck = mock(Deck.class);
        Blackjack bj = mock(Blackjack.class);
        Card card1 = new Card('C', "8");
        PlayGame game = new PlayGame();
        game.setGame(bj);
        game.setDeck(deck);
        when(deck.drawCard()).thenReturn(card1);

        game.dealInitialCards();

        assertAll(
                () -> verify(bj, times(2)).addCardToPlayer(card1),
                () -> verify(bj, times(2)).addCardToDealer(card1)

        );

    }

    @Test public void checkNaturalsTieTest(){
        Blackjack bj = mock(Blackjack.class);
        PlayGame game = new PlayGame();
        game.setGame(bj);


        when(bj.getPlayerTotal()).thenReturn(21);
        when(bj.getDealerTotal()).thenReturn(21);

        game.checkNaturals();

        assertEquals(1, game.gameOutcome);


    }

    @Test public void checkNaturalsPlayerWin(){
        Blackjack bj = mock(Blackjack.class);
        PlayGame game = new PlayGame();
        game.setGame(bj);


        when(bj.getPlayerTotal()).thenReturn(21);
        when(bj.getDealerTotal()).thenReturn(2);

        game.checkNaturals();

        assertEquals(2, game.gameOutcome);



    }

    @Test public void checkDealerWin(){
        Blackjack bj = mock(Blackjack.class);
        PlayGame game = new PlayGame();
        game.setGame(bj);


        when(bj.getPlayerTotal()).thenReturn(5);
        when(bj.getDealerTotal()).thenReturn(21);

        game.checkNaturals();

        assertEquals(3, game.gameOutcome);

    }


    @Test public void checkNoNatural(){
        Blackjack bj = mock(Blackjack.class);
        PlayGame game = new PlayGame();
        game.setGame(bj);


        when(bj.getPlayerTotal()).thenReturn(5);
        when(bj.getDealerTotal()).thenReturn(5);

        game.checkNaturals();

        assertEquals(0, game.gameOutcome);



    }

    @Test public void getDealerHand(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);
        when(bj.getDealerHand()).thenReturn(new ArrayList<>());

        game.getDealerHand();
        verify(bj, times(1)).getDealerHand();
    }

    @Test public void getPlayerHand(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);
        when(bj.getPlayerHand()).thenReturn(new ArrayList<>());

        game.getPlayerHand();
        verify(bj, times(1)).getPlayerHand();

    }

    @Test public void playerTotalTest(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);
        when(bj.getPlayerTotal()).thenReturn(21);

        game.playerTotal();
        verify(bj, times(1)).getPlayerTotal();
    }

    @Test public void dealerTotalTest(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);
        when(bj.getDealerTotal()).thenReturn(21);

        game.dealerTotal();

        verify(bj, times(1)).getDealerTotal();
    }

    @Test public void playerTurnTest(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        Deck deck = mock(Deck.class);
        Card card1 = new Card('C', "8");
        game.setGame(bj);
        game.setDeck(deck);
        when(deck.drawCard()).thenReturn(card1);


        game.playerTurn();

        verify(bj, times(1)).addCardToPlayer(card1);
    }


    @Test public void clearHandsTest(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);

        ArrayList<Card> mockDealerHand = mock(ArrayList.class);
        ArrayList<Card> mockPlayerHand = mock(ArrayList.class);

        when(bj.getPlayerHand()).thenReturn(mockPlayerHand);
        when(bj.getDealerHand()).thenReturn(mockDealerHand);

        game.clearHands();

        verify(mockDealerHand, times(1)).clear();
        verify(mockPlayerHand, times(1)).clear();




    }

    @Test public void determineWinnerTest(){
        PlayGame game = new PlayGame();
        Blackjack bj = mock(Blackjack.class);
        game.setGame(bj);
        when(bj.calculateHandTotal(any(ArrayList.class))).thenReturn(21);
        game.determineWinner();
        assertEquals(1, game.gameOutcome);
    }



//setup for testing terminal output
   /* private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }



//dealInitialCards method testing
    @Test
    public void testDealInitialCards() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame playGame = new PlayGame(mockGame, mockScanner);

        Card mockCard1 = new Card('H', "10");
        Card mockCard2 = new Card('D', "9");
        Card mockCard3 = new Card('C', "8");
        Card mockCard4 = new Card('S', "7");
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();

        when(mockGame.drawCard()).thenReturn(mockCard1, mockCard2, mockCard3, mockCard4);
        when(mockGame.getPlayerHand()).thenReturn(playerHand);
        when(mockGame.getDealerHand()).thenReturn(dealerHand);

        doAnswer(invocation -> {
            Card card = invocation.getArgument(0);
            playerHand.add(card);
            return null;
        }).when(mockGame).addCardToPlayer(any(Card.class));

        doAnswer(invocation -> {
            Card card = invocation.getArgument(0);
            dealerHand.add(card);
            return null;
        }).when(mockGame).addCardToDealer(any(Card.class));

        playGame.dealInitialCards();

        verify(mockGame, times(2)).addCardToPlayer(any(Card.class));
        verify(mockGame, times(2)).addCardToDealer(any(Card.class));
        verify(mockGame).addCardToPlayer(mockCard1);
        verify(mockGame).addCardToPlayer(mockCard3);
        verify(mockGame).addCardToDealer(mockCard2);
        verify(mockGame).addCardToDealer(mockCard4);
    }


//checkNaturals method testing
    @Test
    public void testCheckNaturalsTie() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame playGame = new PlayGame(mockGame, mockScanner);

        when(mockGame.getPlayerTotal()).thenReturn(21);
        when(mockGame.getDealerTotal()).thenReturn(21);

        playGame.checkNaturals();

        verify(mockGame).getPlayerTotal();
        verify(mockGame).getDealerTotal();

        assertEquals(1, playGame.getGameOutcome());
    }
    @Test
    public void testCheckNaturalsPlayer() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame playGame = new PlayGame(mockGame, mockScanner);

        when(mockGame.getPlayerTotal()).thenReturn(21);
        when(mockGame.getDealerTotal()).thenReturn(2);

        playGame.checkNaturals();

        verify(mockGame, times(2)).getPlayerTotal();
        verify(mockGame).getDealerTotal();
        assertEquals(2, playGame.getGameOutcome());
    }
    @Test
    public void testCheckNaturalsDealer() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);

        PlayGame playGame = new PlayGame(mockGame, mockScanner);

        when(mockGame.getPlayerTotal()).thenReturn(2);
        when(mockGame.getDealerTotal()).thenReturn(21);

        playGame.checkNaturals();


        verify(mockGame, times(2)).getPlayerTotal();
        verify(mockGame, times(1)).getDealerTotal();
        assertEquals(3, playGame.getGameOutcome());
    }
    @Test
    public void testCheckNaturalsNeither() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);

        PlayGame playGame = new PlayGame(mockGame, mockScanner);

        when(mockGame.getPlayerTotal()).thenReturn(2);
        when(mockGame.getDealerTotal()).thenReturn(2);

        playGame.checkNaturals();

        verify(mockGame, times(2)).getPlayerTotal();
        verify(mockGame, times(1)).getDealerTotal();
        assertEquals(0, playGame.getGameOutcome());
    }


//playerTurn method testing
    @Test
    public void testPlayerTurnHit() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = new Scanner("h\ns\n");
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);
        when(mockGame.drawCard()).thenReturn(new Card('H',"5")); // return some valid card

        gameUnderTest.playerTurn();
        verify(mockGame, times(1)).addCardToPlayer(any(Card.class));
    }
    @Test
    public void testPlayerTurnHitGet21() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = new Scanner("h\ns\n");
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);
        List<Card> mockPlayerHand = new ArrayList<>();

        when(mockGame.getPlayerHand()).thenReturn((ArrayList<Card>) mockPlayerHand);
        when(mockGame.calculateHandTotal((ArrayList<Card>) mockPlayerHand)).thenReturn(21);

        int result = gameUnderTest.playerTurn();
        assertEquals(0, result);
    }
    @Test
    public void testPlayerTurnHitBust() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = new Scanner("h\ns\n");
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);
        List<Card> mockPlayerHand = new ArrayList<>();

        when(mockGame.getPlayerHand()).thenReturn((ArrayList<Card>) mockPlayerHand);
        when(mockGame.calculateHandTotal((ArrayList<Card>) mockPlayerHand)).thenReturn(23);

        int result = gameUnderTest.playerTurn();
        assertEquals(1, result);
    }
    @Test
    public void testPlayerTurnStand() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = new Scanner("s\n");
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);

        gameUnderTest.playerTurn();

        verify(mockGame, never()).addCardToPlayer(any(Card.class));
    }


//dealerTurn method testing
    @Test
    public void testDealerTurnAddCardOnceWhenTotalIs16() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.calculateHandTotal(mockGame.getDealerHand())).thenReturn(16, 17); // the second return is for after adding a card
        doNothing().when(mockGame).addCardToDealer(any(Card.class));

        when(mockGame.drawCard()).thenReturn(new Card('H', "3"));  // you can replace with any valid card

        gameUnderTest.dealerTurn();

        verify(mockGame, times(1)).addCardToDealer(any(Card.class));
    }
    @Test
    public void testDealerTurnNoAddCardWhenTotalIs17() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.calculateHandTotal(mockGame.getDealerHand())).thenReturn(17);
        doNothing().when(mockGame).addCardToDealer(any(Card.class));

        gameUnderTest.dealerTurn();

        verify(mockGame, never()).addCardToDealer(any(Card.class));
    }

//determineWinner method testing
    @Test
    public void testDetermineWinner_DealerWins() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.calculateHandTotal(any(ArrayList.class))).thenReturn(20, 21);

        gameUnderTest.determineWinner();

        assertEquals(3, gameUnderTest.getGameOutcome());
    }
    @Test
    public void testDetermineWinner_PlayerWins() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.calculateHandTotal(any(ArrayList.class))).thenReturn(21, 20);

        gameUnderTest.determineWinner();

        assertEquals(2, gameUnderTest.getGameOutcome());
    }
    @Test
    public void testDetermineWinner_Tie() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.calculateHandTotal(any(ArrayList.class))).thenReturn(20, 20);

        gameUnderTest.determineWinner();

        assertEquals(1, gameUnderTest.getGameOutcome());
    }


//endGame method testing
    @Test
    public void testEndGame_Tie() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.getPlayerTotal()).thenReturn(20);
        when(mockGame.getDealerTotal()).thenReturn(20);

        gameUnderTest.endGame(1);

        String expectedOutput = "Game Over!\nYou: 20 Dealer: 20\nIt's a tie!\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testEndGame_PlayerWins() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.getPlayerTotal()).thenReturn(21);
        when(mockGame.getDealerTotal()).thenReturn(20);

        gameUnderTest.endGame(2);

        String expectedOutput = "Game Over!\nYou: 21 Dealer: 20\nPlayer wins!\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testEndGame_DealerWins() {
        Blackjack mockGame = mock(Blackjack.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, null);

        when(mockGame.getPlayerTotal()).thenReturn(19);
        when(mockGame.getDealerTotal()).thenReturn(20);

        gameUnderTest.endGame(3);

        String expectedOutput = "Game Over!\nYou: 19 Dealer: 20\nDealer wins!\n";
        assertEquals(expectedOutput, outContent.toString());
    }


//play method testing
    @Test
    public void testPlayNaturals() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = spy(new PlayGame(mockGame, mockScanner));

        gameUnderTest.gameOutcome = 1;

        doNothing().when(gameUnderTest).dealInitialCards();
        doNothing().when(gameUnderTest).checkNaturals();
        doNothing().when(gameUnderTest).dealerTurn();
        doNothing().when(gameUnderTest).determineWinner();
        doNothing().when(gameUnderTest).endGame(anyInt());

        gameUnderTest.play();

        verify(gameUnderTest).dealInitialCards();
        verify(gameUnderTest).checkNaturals();
        verify(gameUnderTest, never()).playerTurn();
        verify(gameUnderTest, never()).dealerTurn();
        verify(gameUnderTest, never()).determineWinner();
        verify(gameUnderTest).endGame(1); // Tie due to both having naturals
    }
    @Test
    public void testPlayNoNaturalsPlayerBust() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = spy(new PlayGame(mockGame, mockScanner));

        gameUnderTest.gameOutcome = 0;

        doNothing().when(gameUnderTest).dealInitialCards();
        doNothing().when(gameUnderTest).checkNaturals();
        doNothing().when(gameUnderTest).dealerTurn();
        doNothing().when(gameUnderTest).determineWinner();
        doNothing().when(gameUnderTest).endGame(anyInt());
        doReturn(1).when(gameUnderTest).playerTurn();

        gameUnderTest.play();

        verify(gameUnderTest).dealInitialCards();
        verify(gameUnderTest).checkNaturals();
        verify(gameUnderTest, never()).dealerTurn();
        verify(gameUnderTest).determineWinner();
        verify(gameUnderTest).endGame(gameUnderTest.gameOutcome); // Dealer Wins bc of Player bust
    }
    @Test
    public void testPlayNoNaturalsPlayerNoBust() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = spy(new PlayGame(mockGame, mockScanner));

        gameUnderTest.gameOutcome = 0;

        doNothing().when(gameUnderTest).dealInitialCards();
        doNothing().when(gameUnderTest).checkNaturals();
        doNothing().when(gameUnderTest).dealerTurn();
        doNothing().when(gameUnderTest).determineWinner();
        doNothing().when(gameUnderTest).endGame(anyInt());
        doReturn(0).when(gameUnderTest).playerTurn();

        gameUnderTest.play();

        verify(gameUnderTest).dealInitialCards();
        verify(gameUnderTest).checkNaturals();
        verify(gameUnderTest).dealerTurn();
        verify(gameUnderTest).determineWinner();
        verify(gameUnderTest).endGame(gameUnderTest.gameOutcome); // Dealer Wins bc of Player bust
    }


//PrintHand method testing
    @Test
    public void testPrintHandPlayer() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);

        List<Card> mockPlayerHand = new ArrayList<>();
        mockPlayerHand.add(new Card('H', "6"));
        mockPlayerHand.add(new Card('D', "5"));
        when(mockGame.getPlayerHand()).thenReturn((ArrayList<Card>) mockPlayerHand);
        when(mockGame.getPlayerTotal()).thenReturn(11); // 6 + 5

        gameUnderTest.printHand("player");

        String expectedOutput = "Your hand: [6H, 5D] (11)\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testPrintHandPlayerEmpty() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);

        List<Card> mockPlayerHand = new ArrayList<>();
        when(mockGame.getPlayerHand()).thenReturn((ArrayList<Card>) mockPlayerHand);
        when(mockGame.getPlayerTotal()).thenReturn(0);

        gameUnderTest.printHand("player");

        String expectedOutput = "Player hand is empty\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testPrintHandDealer() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);

        List<Card> mockDealerHand = new ArrayList<>();
        mockDealerHand.add(new Card('H', "6"));
        mockDealerHand.add(new Card('D', "5"));
        when(mockGame.getDealerHand()).thenReturn((ArrayList<Card>) mockDealerHand);
        when(mockGame.getDealerTotal()).thenReturn(11); // 6 + 5

        gameUnderTest.printHand("dealer");

        String expectedOutput = "Dealer hand: [6H, 5D] (11)\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testPrintHandDealerEmpty() {
        Blackjack mockGame = mock(Blackjack.class);
        Scanner mockScanner = mock(Scanner.class);
        PlayGame gameUnderTest = new PlayGame(mockGame, mockScanner);

        List<Card> mockDealerHand = new ArrayList<>();
        when(mockGame.getDealerHand()).thenReturn((ArrayList<Card>) mockDealerHand);
        when(mockGame.getDealerTotal()).thenReturn(0);

        gameUnderTest.printHand("dealer");

        String expectedOutput = "Dealer hand is empty\n";
        assertEquals(expectedOutput, outContent.toString());
    }


}







*/
}