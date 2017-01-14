package Dice;

import java.util.Arrays;
import java.util.Random;

public class MonopolyCup extends DiceCup {
    private SpeedDie speedDie;

    public MonopolyCup(Random rng) {
        super(new D6(rng), new D6(rng));
        this.speedDie = new SpeedDie(rng);
    }

    @Override
    public DiceCup roll() {
        super.roll();
        this.speedDie.roll();
		return this;
    }

    public SpeedDie getSpeedDie() {
        return this.speedDie;
    }

    public boolean triple(){
	    return this.speedDie.getValue() < 4 && Arrays.stream(this.getValues()).allMatch(i -> i == this.speedDie.getValue());
    }

    @Override
	public int getSum() {
		if (this.speedDie.getValue() < 4)
			return super.getSum() + this.speedDie.getValue();
		return super.getSum();
	}

	public int[] getCombinations(){
    	return new int[]{this.dice[0].getValue(), this.dice[1].getValue(), super.getSum()};
	}
}
