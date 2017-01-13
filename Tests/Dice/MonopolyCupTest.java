package Dice;

import Game.SmartTemplateTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MonopolyCupTest extends SmartTemplateTest{
	@Test
	public void testRoll() throws Exception {
		Arrays.stream(cup.getDice()).forEach(die -> assertThat(die.getValue()).isEqualTo(0));
		assertThat(cup.getSpeedDie().getValue()).isEqualTo(0);

		random.add(1,1,1);
		cup.roll();
		Arrays.stream(cup.getDice()).forEach(die -> assertThat(die.getValue()).isEqualTo(1));
		assertThat(cup.getSpeedDie().getValue()).isEqualTo(1);

	}


	@Test
	public void testTriple() throws Exception {
		random.add(1,1,1);
		cup.roll();
		assertThat(cup.triple()).isTrue();

		random.add(1,2,3);
		cup.roll();
		assertThat(cup.triple()).isFalse();


	}

	@Test
	public void testYahtzee() throws Exception {
		random.add(3,3,2);
		cup.roll();
		assertThat(cup.yahtzee()).isTrue();

		random.add(6,5,4);
		cup.roll();
		assertThat(cup.yahtzee()).isFalse();
	}


	@Test
	public void testGetCombinations() throws Exception {
		random.add(1,2,5);
		cup.roll();
		int[] combinations = cup.getCombinations();
		assertThat(combinations).contains(1,3,2);
		assertThat(new int[]{1,2,3}).contains(combinations);
	}


	@Test
	public void testGetSum() throws Exception {
		random.add(2,2,2);
		cup.roll();
		assertThat(cup.getSum()).isEqualTo(6);

		random.add(4,4,4);
		cup.roll();
		assertThat(cup.getSum()).isEqualTo(8);
	}
}