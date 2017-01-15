package Dice;

import java.util.Random;

public class SpeedDie extends Die{
    SpeedDie(Random rng) {
        super(6, rng);
    }

    @Override
    public String toString() {
		switch (this.getValue()) {
            case 1:
				return "SpeedDie1Face";
            case 2:
            	return "SpeedDie2Face";
            case 3:
                return "SpeedDie3Face";
            case 4:
            case 5:
                return "SpeedDieMrMonopolyFace";
            case 6:
                return "SpeedDieBusFace";
        }
        throw new AssertionError();
    }
}
