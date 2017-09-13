package com.example.kelseyde.snakesandladders;

import java.util.ArrayList;


public class Game implements Playable {

    private Rollable dice;
    private ArrayList<Player> players;
    private Board board;
    private Player currentPlayer;

    public Game(Rollable dice, ArrayList<Player> players, Board board) {
        this.dice = dice;
        this.players = players;
        this.board = board;
        this.currentPlayer = players.get(0);
    }

    //getters and setters

    public Rollable getDice() {
        return dice;
    }

    public void setDice(Rollable dice) {
        this.dice = dice;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    //methods

    public boolean hasWon() {
        boolean hasWon = false;
        for (Player player : players) {
            if (player.getPosition() >= board.getWinTile()) {
                hasWon = true;
            }
        }
        return hasWon;
    }

    public Integer validateMovement(Integer spaces) {
        Integer distanceToEnd = board.getWinTile() - currentPlayer.getPosition();
        Integer movement = (spaces > distanceToEnd) ? distanceToEnd : spaces;
        return movement;
    }

    public Integer movePlayer(Integer diceRoll) {
        Integer move = validateMovement(diceRoll);
        currentPlayer.move(move);
        Integer modifier = board.modifierAtPosition(currentPlayer.getPosition());
        currentPlayer.move(modifier);
        return currentPlayer.getPosition();
    }

    public void updateCurrentPlayer() {
        int numberOfPlayers = this.players.size();
        if (players.indexOf(this.currentPlayer) == (numberOfPlayers - 1)) {
            this.currentPlayer = players.get(0);
        } else {
            int newPlayerIndex = (players.indexOf(this.currentPlayer) + 1);
            this.currentPlayer = players.get(newPlayerIndex);
        }
    }

    public void playTurn(){
        int diceRoll = dice.roll();
        movePlayer(diceRoll);
        hasWon();
    }

    public Player playGame() {
        Player winner = null;
        while ( !hasWon() ) {
            playTurn();
            winner = currentPlayer;
            updateCurrentPlayer();
        }
        return winner;
    }



}
