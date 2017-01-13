package Game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SmartGameTest extends SmartTemplateTest {

	//@Test
	public void startTest() {
		random.add(2, 2, 2, 2, 2);
		game.start();

	}
}
