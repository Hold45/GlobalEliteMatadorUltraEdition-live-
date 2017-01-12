package Game;

import Dice.MonopolyCup;
import GUI.SmartGUI;
import Owners.Bank;
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
	protected MonopolyCup cup;
	protected SmartRandom random;
	protected Bank bank;

	@Before
	public void baseSetUp() throws Exception {
		gui = new SmartGUI();
		game = new Game(gui);
		gui.game = game;
		Game.setRandom(new SmartRandom());
		p1 = new Player(game);
		p1.getAccount().setBalance(10000);
		p2 = new Player(game);
		p2.getAccount().setBalance(10000);
		game.addPlayers(p1, p2);
		cup = game.getCup();
		random = (SmartRandom) Game.getRandom();
		bank = game.getBank();
	}

	@After
	public void baseTearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
		cup = null;
		random = null;
		bank = null;
	}
}
