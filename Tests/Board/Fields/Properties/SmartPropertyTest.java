package Board.Fields.Properties;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Buildings.Hotel;
import Buildings.House;
import Game.SmartTemplateTest;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartPropertyTest extends SmartTemplateTest {
	private Property hvid;
	private Property roed;

	@Before
	public void setup(){
		hvid = (Property) game.getBoard().getField(game.getBoard().getIndex(Hvidovrevej.class));
		roed = (Property) game.getBoard().getField(game.getBoard().getIndex(Roedovrevej.class));
	}

	/**
	 * @see Property#upgrade()
	 */
	 @Test
	 public void testUpgrade(){
		 for (int i = 1; i < hvid.upgradeSignature.length; i++) {
			 hvid.upgrade();
			 assertThat(hvid.getUpgradeValue()).isEqualTo(i);
		 }
	 }

	/**
	 * @see Property#tryDowngrade()
	 */
	 @Test
	 public void testDowngrade(){
		 for (int i = 1; i < hvid.upgradeSignature.length; i++)
			 hvid.upgrade();

		 for (int i = hvid.upgradeSignature.length-2; i >= 0 ; i--) {
			 hvid.downgrade();
			 assertThat(hvid.getUpgradeValue()).isEqualTo(i);
		 }
	 }

	@Test
	public void testGetUpgradeValue() throws Exception {
		assertThat(hvid.getUpgradeValue()).isEqualTo(0);

		hvid.getBuildings().add(new House());
		assertThat(hvid.getUpgradeValue()).isEqualTo(1);

		hvid.getBuildings().add(new House());
		assertThat(hvid.getUpgradeValue()).isEqualTo(2);

		hvid.getBuildings().add(new House());
		assertThat(hvid.getUpgradeValue()).isEqualTo(3);

		hvid.getBuildings().add(new House());
		assertThat(hvid.getUpgradeValue()).isEqualTo(4);

		hvid.getBuildings().add(new Hotel());
		assertThat(hvid.getUpgradeValue()).isEqualTo(5);
	}




}