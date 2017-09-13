package com.example.kelseyde.snakesandladders;


import java.util.Random;

public class WildCardPlayer {

    private String name;
    private int position;

    public WildCardPlayer(String name) {
        this.name = name;
        this.position = 0;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int move(int spaces) {
        Random rand = new Random(2);
        int wildCard = rand.nextInt( 2 - 1 ) + 1;
        if (wildCard == 1) {
            position += (spaces / 2);
        } else {
            position += (spaces * 2);
        }
        return position;
    }

}
