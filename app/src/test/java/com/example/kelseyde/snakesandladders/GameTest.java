package com.example.kelseyde.snakesandladders;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Rollable dice;
    Rollable fakeDice;
    Player player;
    Player player2;
    Board board;
    ArrayList<Player> players;
    HashMap<Integer, Integer> snakesAndLadders;

    @Before
    public void before() {
        dice = new Dice(6);
        fakeDice = new FakeDice(4);
        board = new Board(10);
        snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(new Integer(5), new Integer(2));
        snakesAndLadders.put(new Integer(8), new Integer(-2));
        board.setModifiers(snakesAndLadders);
        player = new Player("Meg");
        player2 = new Player("Bob");
        players = new ArrayList<Player>();
        players.add(player);
        players.add(player2);
        game = new Game(fakeDice, players, board);
    }

    @Test
    public void testPlayerCanWin() {
        player.setPosition(10);
        assertEquals(true, game.hasWon());
    }

    @Test
    public void testMovePlayerNotEndOfBoard() {
        game.movePlayer(4);
        assertEquals(4, player.getPosition());
    }

    @Test
    public void testDistanceToEnd() {
        assertEquals(0, game.getCurrentPlayer().getPosition());
        assertEquals(new Integer(9), board.getWinTile());
        assertEquals(9, (board.getWinTile() - game.getCurrentPlayer().getPosition()));
    }

    @Test
    public void testValidateMovementNotEnd() {
        assertEquals(new Integer(4), game.validateMovement(4));
    }

    @Test
    public void testValidateMovementEnd() {
        assertEquals(new Integer(9), game.validateMovement(11));
    }

    @Test
    public void testMovePlayerEndOfBoard() {
        player.setPosition(7);
        game.movePlayer(5);
        assertEquals(9, player.getPosition());
    }

    @Test
    public void testUpdateCurrentPlayerNotLast() {
        game.updateCurrentPlayer();
        assertEquals(player2, game.getCurrentPlayer());
    }

    @Test
    public void testUpdateCurrentPlayerLast() {
        game.updateCurrentPlayer();
        game.updateCurrentPlayer();
        assertEquals(player, game.getCurrentPlayer());
    }

    @Test
    public void testPlayTurn() {
        game.playTurn();
        assertEquals(4, player.getPosition());
    }

    @Test
    public void testPlayGame() {
        assertEquals( player, game.playGame() );
    }



}