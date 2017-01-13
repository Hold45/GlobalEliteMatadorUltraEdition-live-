package Game;

import GUI.DummyGUI;
import Owners.Player;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

/**
 *
 */
public abstract class DumTemplateTest {
	protected Game game;
	protected Player p1;
	protected Player p2;
	protected DummyGUI gui;

	@Before
	public void baseSetUp() throws Exception{
		System.setProperty("java.awt.headless", "true");
		gui = new DummyGUI();
		game = new Game(gui);
		gui.game = game;
		p1 = new Player(game);
		p1.getAccount().setBalance(10000);
		p2 = new Player(game);
		p2.getAccount().setBalance(10000);
		game.addPlayers(p1, p2);
	}

	@After
	public void BaseTearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
	}
}
