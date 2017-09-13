package com.example.kelseyde.snakesandladders;


public class FakeDice implements Rollable {

    private Integer sides;

    public Integer getSide() {
        return sides;
    }

    public void setSide(Integer side) {
        this.sides = sides;
    }

    public FakeDice(Integer sides){
        this.sides = sides;
    }

    public Integer roll() {
        return sides;
    }
}
