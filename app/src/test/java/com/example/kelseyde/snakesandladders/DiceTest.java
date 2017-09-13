package com.example.kelseyde.snakesandladders;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    FakeDice dice;
    Integer integer;

    @Before
    public void before() {
        dice = new FakeDice(6);
        integer = new Integer(6);
    }

    @Test

    public void testReturns6() {
        assertEquals(integer, dice.roll());
    }



}