package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Game.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DowngradePropertyTest extends SmartTemplateTest {


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