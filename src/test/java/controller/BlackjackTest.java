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
        game.addCardToDealer(new Card('h', '5'));
        assertEquals(5, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationJack() {
        game.addCardToDealer(new Card('h', 'j'));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationQueen() {
        game.addCardToDealer(new Card('h', 'q'));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationKing() {
        game.addCardToDealer(new Card('h', 'k'));
        assertEquals(10, game.getDealerTotal());
    }

    @Test
    public void testCardNumberInterpretationAce() {
        game.addCardToDealer(new Card('h', 'a'));
        assertEquals(11, game.getDealerTotal());
    }

    @Test
    public void testCalculateHandTotalWithNoAces() {
        game.addCardToPlayer(new Card('h', '7'));
        game.addCardToPlayer(new Card('s', 'k'));
        assertEquals(17, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithOneAceAsEleven() {
        game.addCardToPlayer(new Card('h', 'a'));
        game.addCardToPlayer(new Card('s', 'k'));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithOneAceAsOne() {
        game.addCardToPlayer(new Card('h', 'a'));
        game.addCardToPlayer(new Card('s', 'k'));
        game.addCardToPlayer(new Card('d', 'k'));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithTwoAces() {
        game.addCardToPlayer(new Card('h', 'a'));
        game.addCardToPlayer(new Card('s', 'a'));
        //12
        game.addCardToPlayer(new Card('d', 'k'));
        assertEquals(12, game.getPlayerTotal());
    }

    @Test
    public void testCalculateHandTotalWithTwoAcesOver21() {
        game.addCardToPlayer(new Card('h', 'a'));
        game.addCardToPlayer(new Card('s', 'a'));
        //12
        game.addCardToPlayer(new Card('d', 'k'));
        //12
        game.addCardToPlayer(new Card('c', '8'));
        assertEquals(20, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithThreeAces() {
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('d', '7'));
        //19
        game.addCardToPlayer(new Card('s', 'a'));
        assertEquals(20, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithFourAces() {
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('d', '7'));
        //19
        game.addCardToPlayer(new Card('s', 'a'));
        //20
        game.addCardToPlayer(new Card('s', 'a'));
        assertEquals(21, game.getPlayerTotal());
    }

    @Test //seperate out these assertions
    public void testCalculateHandTotalWithFiveAces() {
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('s', 'a'));
        game.addCardToPlayer(new Card('d', '7'));
        //19
        game.addCardToPlayer(new Card('s', 'a'));
        //20
        game.addCardToPlayer(new Card('s', 'a'));
        //21
        game.addCardToPlayer(new Card('s', 'a'));
        //12
    }

    @Test
    public void testDealerHandTotal() {
        game.addCardToDealer(new Card('h', '5'));
        game.addCardToDealer(new Card('s', 'k'));
        assertEquals(15, game.getDealerTotal());
    }

    @Test
    public void testShowPlayerHandOneCard(){
        game.addCardToPlayer(new Card('h', '5'));
        assertEquals("[5h]",game.getPlayerHand().toString());
    }

    @Test
    public void testShowPlayerHandMultipleCards(){
        game.addCardToPlayer(new Card('h', '5'));
        game.addCardToPlayer(new Card('s', '4'));
        assertEquals("[5h, 4s]",game.getPlayerHand().toString());
    }

    @Test
    public void testShowDealerHandOneCard(){
        game.addCardToDealer(new Card('h', '5'));
        assertEquals("[5h]",game.getDealerHand().toString());
    }

    @Test
    public void testShowDealerHandMultipleCards(){
        game.addCardToDealer(new Card('h', '5'));
        game.addCardToDealer(new Card('s', '4'));
        assertEquals("[5h, 4s]",game.getDealerHand().toString());
    }

}
