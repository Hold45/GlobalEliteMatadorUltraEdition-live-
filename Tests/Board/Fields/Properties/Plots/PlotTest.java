package Board.Fields.Properties.Plots;

import GUI.SmartGUI;
import Game.Game;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Board.Fields.Properties.Plots.BluePlots.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PlotTest {
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
	public void getRent() throws Exception {
		Plot[] plots = Arrays.stream(game.getBoard().getFields())
				.filter(field -> field instanceof BluePlot)
					.toArray(Plot[]::new);


		plots[0].getDeed().setOwner(p1);
		assertThat(plots[0].getRent()).isEqualTo(plots[0].getRentScheme()[0]);

		plots[1].getDeed().setOwner(p1);
		assertThat(plots[1].getRent()).isEqualTo(plots[1].getRentScheme()[0]*2);


	}

}