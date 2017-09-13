package com.example.kelseyde.snakesandladders;


public interface Playable {

    boolean hasWon();

    void playTurn();

    Integer validateMovement(Integer spaces);

    Integer movePlayer(Integer diceRoll);

//    void startGame();





}
