package com.example.kelseyde.snakesandladders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board {

    private Integer size;
    private ArrayList<Integer> positions;

    public Board(Integer size) {
        this.size = size;
        this.positions = new ArrayList<Integer>(Collections.nCopies(size, 0));
    }

    //getters and setters

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Integer> positions) {
        this.positions = positions;
    }

    //methods

    public void setModifiers(HashMap<Integer, Integer> modifiers){
        for (int key : modifiers.keySet()) {
            positions.remove(key);
            positions.add(key, modifiers.get(key));
        }
    }

    public Integer modifierAtPosition(Integer position) {
        return positions.get(position);
    }

    public Integer getWinTile() {
        return size - 1;
    }


}
