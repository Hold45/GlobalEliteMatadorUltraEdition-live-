package Dice;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class DiceCup {
    Die[] dice;

    DiceCup(Die... dice){
        this.dice = dice;
    }

    public int[] getValues(){
        return Stream.of(this.dice).mapToInt(Die::getValue).toArray();
    }

    public int getSum(){
        return Arrays.stream(this.getValues()).sum();
    }

    Die[] getDice(){
        return this.dice;
    }

    public DiceCup roll(){
        Stream.of(this.dice).forEach(Die::roll);
        return this;
    }
    public boolean yahtzee(){
        return Arrays.stream(this.getValues()).allMatch(i -> i == this.dice[0].getValue());
    }

}
