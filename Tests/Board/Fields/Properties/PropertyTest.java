package Board.Fields.Properties;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.Plot;
import Buildings.Hotel;
import Buildings.House;
import GUI.SmartGUI;
import Game.Game;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class PropertyTest {
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
	public void getUpgradeValue() throws Exception {
		Property property = (Property) game.getBoard().getField(game.getBoard().getIndex(Hvidovrevej.class));

		assertThat(property.getUpgradeValue()).isEqualTo(0);

		property.getBuildings().add(new House());
		assertThat(property.getUpgradeValue()).isEqualTo(1);

		property.getBuildings().add(new House());
		assertThat(property.getUpgradeValue()).isEqualTo(2);

		property.getBuildings().add(new House());
		assertThat(property.getUpgradeValue()).isEqualTo(3);

		property.getBuildings().add(new House());
		assertThat(property.getUpgradeValue()).isEqualTo(4);

		property.getBuildings().add(new Hotel());
		assertThat(property.getUpgradeValue()).isEqualTo(5);
	}

}