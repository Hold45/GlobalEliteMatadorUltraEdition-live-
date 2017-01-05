package Game;

import GUI.SmartGUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game(new SmartGUI());

	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void testStart() throws Exception {
		game.start();
	}

}