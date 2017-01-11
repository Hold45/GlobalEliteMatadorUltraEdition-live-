package Game;

import GUI.SmartGUI;
import Owners.Player;
import org.junit.After;
import org.junit.Before;

/**
 *
 */
public abstract class SmartTemplateTest {
	protected Game game;
	protected Player p1;
	protected Player p2;
	protected SmartGUI gui;
	protected int[] randomValues = new int[]{4,3,6,2,3,4,5,3,2,3};

	@Before
	public void baseSetUp() throws Exception {
		gui = new SmartGUI();
		game = new Game(gui);
		Game.getRandom().setSeed(474773378);
		p1 = new Player(game);
		p1.getAccount().setBalance(10000);
		p2 = new Player(game);
		p2.getAccount().setBalance(10000);
		game.addPlayers(p1, p2);
	}

	@After
	public void baseTearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
	}
}
