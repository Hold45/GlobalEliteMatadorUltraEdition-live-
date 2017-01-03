package Dice;

public class MonopolyCup extends DiceCup {
    private SpeedDie speedDie;

    public MonopolyCup() {
        super(new D6(), new D6());
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
}
