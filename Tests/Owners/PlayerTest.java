package Owners;

import GUI.SmartGUI;
import Game.Actions.ProposeTrade;
import Game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest{
	protected Game game;
	protected Player p1;
	protected Player p2;

	@Before
	public void setUp() throws Exception {
		game = new Game(new SmartGUI());
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

	@Test
	public void takeActions() throws Exception {
		p1.takeActions(ProposeTrade.self);
	}

}