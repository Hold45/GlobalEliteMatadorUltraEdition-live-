package Dice;

import java.util.Random;

public abstract class Die {
    private int value;
    private int sides;
    private static Random random = new Random();

    Die(int sides){
        this.sides = sides;
    }

    public int roll() {
        this.value = Die.random.nextInt(sides)+1;
        return this.value;
    }

    public int getValue() {
        return value;
    }
}
