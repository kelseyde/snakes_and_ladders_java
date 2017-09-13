package com.example.kelseyde.snakesandladders;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;
    HashMap<Integer, Integer> snakesAndLadders;

    @Before
    public void before() {
        board = new Board(10);
        snakesAndLadders = new HashMap<Integer, Integer>();
        snakesAndLadders.put(new Integer(5), new Integer(2));
        snakesAndLadders.put(new Integer(8), new Integer(-2));
        board.setModifiers(snakesAndLadders);
    }

    @Test
    public void testBoardSize() {
        assertEquals(10, board.getPositions().size());
    }

    @Test
    public void testPositionsSetUp() {
        assertEquals(new Integer(0), board.getPositions().get(0));
        assertEquals(new Integer(2), board.getPositions().get(5));
        assertEquals(new Integer(-2), board.getPositions().get(8));
    }

    @Test
    public void testModifierAtPosition() {
        assertEquals(new Integer(2), board.modifierAtPosition(5));
        assertEquals(new Integer(-2), board.modifierAtPosition(8));
    }






}