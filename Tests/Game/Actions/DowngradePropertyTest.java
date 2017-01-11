package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Plots.YellowPlots.Amagertorv;
import Board.Fields.Properties.Property;
import GUI.SmartGUI;
import Game.Game;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DowngradePropertyTest {
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
		gui = null;
		p1 = null;
		p2 = null;
	}

	@Test
	public void testRunnable() throws Exception {
		Deed hvid = ((Property)game.getBoard().getField(Hvidovrevej.class)).getDeed();
		Deed roed = ((Property)game.getBoard().getField(Roedovrevej.class)).getDeed();
		game.getBank().transferTradableTo(p1, hvid);
		game.getBank().transferTradableTo(p1, roed);

		Action downgrade = DowngradeProperty.self;

		assertThat(downgrade.runnable(p1)).isFalse();


		hvid.getProperty().upgrade();
		assertThat(downgrade.runnable(p1)).isTrue();

		roed.getProperty().upgrade();
		roed.getProperty().upgrade();
		assertThat(downgrade.runnable(p1)).isTrue();
	}
}