package Board.Fields.Properties;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Buildings.Hotel;
import Buildings.House;
import Game.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PropertyTest extends SmartTemplateTest {

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