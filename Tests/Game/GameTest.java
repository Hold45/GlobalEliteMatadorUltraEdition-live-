package Game;

import GUI.DummyGUI;
import GUI.SmartGUI;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	private Player p1;
	private Player p2;
	private DummyGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new DummyGUI();
		game = new Game(gui);
		p1 = new Player(game);
		p1.getAccount().setBalance(10000);
		p2 = new Player(game);
		p2.getAccount().setBalance(10000);
		game.addPlayers(p1, p2);
	}

	@After
	public void tearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
	}


	@Test
	public void testStart() throws Exception {
		for (int i = 0; i < 100; i++) {
			game.start();
		}
	}

}