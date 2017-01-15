package Board.Fields.Properties.Plots;

import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlotTest extends SmartTemplateTest {

	@Test
	public void testGetRent() {
		//Rent when only one is owned
		game.getBank().transferTradableTo(p1, hvid);
		assertThat(hvid.getProperty().getRent()).isEqualTo(50);

		//Rent when all of the same type is owned
		game.getBank().transferTradableTo(p1, roed);
		assertThat(roed.getProperty().getRent()).isEqualTo(100);

		//Rent With one house with all owned
		hvid.getProperty().upgrade();
		assertThat(hvid.getProperty().getRent()).isEqualTo(250);
	}
}