package Game;

import GUI.DummyGUI;
import Owners.Player;
import org.junit.Test;


import java.util.Arrays;
import java.util.Set;

public class GameTest extends DumTemplateTest{

	@Test
	public void testStart() throws Exception {
		for (int i = 0; i < 10; i++) {
			gui = new DummyGUI();
			game = new Game(gui);
			gui.game = game;
			p1 = new Player(game);
			p1.getAccount().setBalance(10000);
			p2 = new Player(game);
			p2.getAccount().setBalance(10000);
			game.addPlayers(p1, p2);
			game.start();
		}
	}

}