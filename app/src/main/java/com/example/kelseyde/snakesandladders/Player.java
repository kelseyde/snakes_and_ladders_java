package com.example.kelseyde.snakesandladders;


public class Player {

    private String name;
    private int position;

    public Player(String name) {
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

    //methods

    public int move(int spaces) {
        position += spaces;
        return position;
    }




}
