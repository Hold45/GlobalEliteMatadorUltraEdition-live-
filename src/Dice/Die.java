package Dice;

import Game.Game;

import java.util.Random;

public abstract class Die{
    private int value;
    private int sides;
    private Random rng;

	/**
	 * @param sides the amount of sides the die has
	 * @param rng the random generator used to roll the die
	 */
	Die(int sides, Random rng){
        this.sides = sides;
        this.rng = rng;
    }

	/**
	 * Rolls the die, setting it to a new random value using the rng
	 * @return the rolled value
	 */
	public int roll() {
    	this.value = this.rng.nextInt(sides)+1;
        return this.value;
    }

    public int getValue() {
        return value;
    }


	/**
	 * @return
	 */
	@Override
	public String toString() {
		return Integer.toString(this.getValue());
	}


}
