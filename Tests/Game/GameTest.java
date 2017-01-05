package Game;

import GUI.DummyGUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game(new DummyGUI());

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