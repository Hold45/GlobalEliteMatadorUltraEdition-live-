package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.YellowPlots.Amagertorv;
import GUI.SmartGUI;
import Game.Game;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ProposeTradeTest {
	private Game game;
	private Player p1;
	private Player p2;
	private SmartGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new SmartGUI();
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
		p1 = null;
		p2 = null;
	}

	@Test
	public void testRun() throws Exception{
		Deed deed = new Amagertorv(game).getDeed();
		p1.addTradable(deed);

		gui.addActions(EndActions.self, EndActions.self, 1000, p2, deed, ProposeTrade.self);

		p1.takeActions(ProposeTrade.self);

		assertThat(p1.getAccount().getBalance()).isEqualTo(11000);
		assertThat(p1.isOwnerOf(deed)).isFalse();
		assertThat(p2.getAccount().getBalance()).isEqualTo(9000);
		assertThat(p2.isOwnerOf(deed)).isTrue();

	}

}