package com.example.kelseyde.snakesandladders;


import java.util.Random;

public class Dice implements Rollable{

    private Integer sides;

    public Dice(Integer sides) {
        this.sides = sides;
    }

    //getters and setters

    public Integer getSides() {
        return sides;
    }

    public void setSides(Integer sides) {
        this.sides = sides;
    }

    //methods

    public Integer roll() {
        Random rand = new Random(sides);
        Integer randomNumber = rand.nextInt( sides - 1 ) + 1;
        return randomNumber;
    }

}
