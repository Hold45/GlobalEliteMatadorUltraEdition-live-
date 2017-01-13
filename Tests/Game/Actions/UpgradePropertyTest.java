package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Game.SmartTemplateTest;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UpgradePropertyTest extends SmartTemplateTest{

	/**
	 * @see UpgradeProperty#run(Player)
	 */
	@Test
	public void testRun() {
		Deed hvid = ((Property)game.getBoard().getField(Hvidovrevej.class)).getDeed();
		Deed roed = ((Property)game.getBoard().getField(Roedovrevej.class)).getDeed();
		game.getBank().transferTradableTo(p1, hvid);
		game.getBank().transferTradableTo(p1, roed);

		Action upgrade = UpgradeProperty.self;

		gui.addActions(hvid);
		upgrade.run(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(9000);
		assertThat(hvid.getProperty().getUpgradeValue()).isEqualTo(1);

	}

	@Test
	public void testRunnable() throws Exception {
		Deed hvid = ((Property)game.getBoard().getField(Hvidovrevej.class)).getDeed();
		Deed roed = ((Property)game.getBoard().getField(Roedovrevej.class)).getDeed();
		Action upgrade = UpgradeProperty.self;

		//Only owns 1 of the blue properties.
		game.getBank().transferTradableTo(p1, hvid);
		assertThat(upgrade.runnable(p1)).isFalse();

		//Only owns 2 of the blue properties.
		game.getBank().transferTradableTo(p1, roed);
		assertThat(upgrade.runnable(p1)).isTrue();

		//Can still upgrade other blue property.
		hvid.getProperty().upgrade();
		assertThat(upgrade.runnable(p1)).isTrue();
	}
}