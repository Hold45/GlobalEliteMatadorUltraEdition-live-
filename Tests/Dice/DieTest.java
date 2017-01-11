package Dice;

import Game.SmartTemplateTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class DieTest extends SmartTemplateTest{

	@Test
	public void testRoll() throws Exception {
		Arrays.stream(randomValues)
				.forEach(i -> assertThat(game.getCup().getDice()[0].roll()).isEqualTo(i));
	}

	@Test
	public void testToString() throws Exception {
		Arrays.stream(randomValues)
				.forEach((int i) -> {
					game.getCup().getDice()[0].roll();
					assertThat(game.getCup().getDice()[0].toString()).isEqualTo(Integer.toString(i));
				});
	}

}