import GUI.DummyGUI;
import Game.Game;
import Owners.Player;
import org.junit.After;
import org.junit.Before;

/**
 *
 */
public abstract class TestSetup {
	protected Game game;
	protected Player p1;
	protected Player p2;

	@Before
	public void setUp() throws Exception {
		game = new Game(new DummyGUI());
		p1 = new Player(game);
		p2 = new Player(game);
		game.addPlayers(p1, p2);
	}

	@After
	public void tearDown() throws Exception {
		game = null;
		p1 = null;
		p2 = null;

	}


}
