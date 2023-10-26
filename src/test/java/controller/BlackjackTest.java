package controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {
    private Blackjack game;

    @BeforeEach
    public void setUp() {
        game = new Blackjack();
    }

    @Test
    public void testCardNumberInterpretationNumbers() {
        game.addCardToDealer(new Card('h', "5"));
        assertEquals(5, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationJack() {
        game.addCardToDealer(new Card('h', "J"));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationQueen() {
        game.addCardToDealer(new Card('h', "Q"));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationKing() {
        game.addCardToDealer(new Card('h', "K"));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationAce() {
        game.addCardToDealer(new Card('h', "A"));
        assertEquals(11, game.getDealerTotal());
    }

    @Test
    public void testCalculateHandTotalWithNoAces() {
        game.addCardToPlayer(new Card('h', "7"));
        game.addCardToPlayer(new Card('s', "K"));
        assertEquals(17, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithOneAceAsEleven() {
        game.addCardToPlayer(new Card('h', "A"));
        game.addCardToPlayer(new Card('s', "K"));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithOneAceAsOne() {
        game.addCardToPlayer(new Card('h', "A"));
        game.addCardToPlayer(new Card('s', "K"));
        game.addCardToPlayer(new Card('d', "K"));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithTwoAces() {
        game.addCardToPlayer(new Card('h', "A"));
        game.addCardToPlayer(new Card('s', "A"));
        //12
        game.addCardToPlayer(new Card('d', "K"));
        assertEquals(12, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithTwoAcesOver21() {
        game.addCardToPlayer(new Card('h', "A"));
        game.addCardToPlayer(new Card('s', "A"));
        //12
        game.addCardToPlayer(new Card('d', "A"));
        //13
        game.addCardToPlayer(new Card('c', "8"));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithThreeAces() {
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('d', "7"));
        //19
        game.addCardToPlayer(new Card('s', "A"));
        assertEquals(20, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithFourAces() {
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('d', "7"));
        //19
        game.addCardToPlayer(new Card('s', "A"));
        //20
        game.addCardToPlayer(new Card('s', "A"));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithFiveAces() {
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('s', "A"));
        game.addCardToPlayer(new Card('d', "7"));
        //19
        game.addCardToPlayer(new Card('s', "A"));
        //20
        game.addCardToPlayer(new Card('s', "A"));
        //21
        game.addCardToPlayer(new Card('s', "A"));
        //12
    }

    @Test
    public void testDealerHandTotal() {
        game.addCardToDealer(new Card('h', "5"));
        game.addCardToDealer(new Card('s', "K"));
        assertEquals(15, game.getDealerTotal());
    }

    @Test
    public void testShowPlayerHandOneCard(){
        game.addCardToPlayer(new Card('h', "5"));
        assertEquals("[5h]",game.getPlayerHand().toString());
    }

    @Test
    public void testShowPlayerHandMultipleCards(){
        game.addCardToPlayer(new Card('h', "5"));
        game.addCardToPlayer(new Card('s', "4"));
        assertEquals("[5h, 4s]",game.getPlayerHand().toString());
    }

    @Test
    public void testShowDealerHandOneCard(){
        game.addCardToDealer(new Card('h', "5"));
        assertEquals("[5h]",game.getDealerHand().toString());
    }

    @Test
    public void testShowDealerHandMultipleCards(){
        game.addCardToDealer(new Card('h', "5"));
        game.addCardToDealer(new Card('s', "4"));
        assertEquals("[5h, 4s]",game.getDealerHand().toString());
    }

}
