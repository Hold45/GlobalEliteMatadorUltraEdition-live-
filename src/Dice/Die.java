package Dice;

import Game.Game;

public abstract class Die{
    private int value;
    private int sides;

    Die(int sides){
        this.sides = sides;
    }

    public int roll() {
    	this.value = Game.getRandom().nextInt(sides)+1;
        return this.value;
    }

    public int getValue() {
        return value;
    }

	@Override
	public String toString() {
		return Integer.toString(this.getValue());
	}


}
