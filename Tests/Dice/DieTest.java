package Dice;

import Game.SmartTemplateTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DieTest extends SmartTemplateTest{

	@Test
	public void testRoll() throws Exception {
		random.add(4,3,6,2,3,4,5,3,2,3);
		Arrays.stream(new int[]{4,3,6,2,3,4,5,3,2,3})
				.forEach(i -> assertThat(game.getCup().getDice()[0].roll()).isEqualTo(i));
	}

	@Test
	public void testToString() throws Exception {
		random.add(4,3,6,2,3,4,5,3,2,3);
		Arrays.stream(new int[]{4,3,6,2,3,4,5,3,2,3})
				.forEach((int i) -> {
					game.getCup().getDice()[0].roll();
					assertThat(game.getCup().getDice()[0].toString()).isEqualTo(Integer.toString(i));
				});
	}

}