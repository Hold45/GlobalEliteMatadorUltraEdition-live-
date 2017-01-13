package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Game.SmartTemplateTest;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DowngradePropertyTest extends SmartTemplateTest {

	/**
	 * @see DowngradeProperty#run(Player)
	 */
	@Test
	public void testRun() {
		Deed hvid = ((Property)game.getBoard().getField(Hvidovrevej.class)).getDeed();
		Deed roed = ((Property)game.getBoard().getField(Roedovrevej.class)).getDeed();
		game.getBank().transferTradableTo(p1, hvid);
		game.getBank().transferTradableTo(p1, roed);

		Action downgrade = DowngradeProperty.self;

		hvid.getProperty().upgrade();

		gui.addActions(hvid);
		downgrade.run(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10500);
		assertThat(hvid.getProperty().getUpgradeValue()).isEqualTo(0);

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