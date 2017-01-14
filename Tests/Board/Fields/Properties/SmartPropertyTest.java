package Board.Fields.Properties;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Ships.RoedbyPuttgarden;
import Board.Fields.Properties.Ships.Ship;
import Buildings.Hotel;
import Buildings.House;
import Game.SmartTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartPropertyTest extends SmartTemplateTest {
	private Property hvid;
	private Property roed;
	private Ship faerge;

	@Before
	public void setup(){
		hvid = (Property) game.getBoard().getField(game.getBoard().getIndex(Hvidovrevej.class));
		roed = (Property) game.getBoard().getField(game.getBoard().getIndex(Roedovrevej.class));
		faerge = (Ship) game.getBoard().getField(game.getBoard().getIndex(RoedbyPuttgarden.class));
	}

	@After
	public void tearDown(){
		hvid = null;
		roed = null;
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

	/**
	 * @see Property#getUpgradeValue()
	 */
	@Test
	public void testGetUpgradeValue(){
		assertThat(hvid.getUpgradeValue()).isEqualTo(0);
		for (int i = 1; i < 5; i++) {
			hvid.getBuildings().add(new House());
			assertThat(hvid.getUpgradeValue()).isEqualTo(i);
		}
		assertThat(roed.getUpgradeValue()).isEqualTo(0);
		game.getBank().transferTradableTo(p1, roed.getDeed());
		assertThat(roed.getUpgradeValue()).isEqualTo(0);
		assertThat(faerge.getUpgradeValue()).isEqualTo(0);
	}

	/**
	 * @see Property#canBeUpgraded()
	 */
	@Test
	public void testCanBeUpgraded(){
		//Player owns no blue fields
		assertThat(hvid.canBeUpgraded()).isFalse();

		//Player owns 1 blue field
		hvid.getDeed().setOwner(p1);
		assertThat(hvid.canBeUpgraded()).isFalse();

		//Player owns all blue fields
		roed.getDeed().setOwner(p1);
		assertThat(hvid.canBeUpgraded()).isTrue();
		assertThat(roed.canBeUpgraded()).isTrue();

		//Upgrade to max and check if still upgradable
		for (int i = 0; i < roed.upgradeSignature.length-2; i++) {
			roed.upgrade();
			assertThat(roed.canBeUpgraded()).isFalse();
			hvid.upgrade();
			assertThat(hvid.canBeUpgraded()).isTrue();
			assertThat(roed.canBeUpgraded()).isTrue();
		}
		roed.upgrade();
		hvid.upgrade();
		assertThat(hvid.canBeUpgraded()).isFalse();
		assertThat(roed.canBeUpgraded()).isFalse();
	}

	/**
	 * @see Property#canBeDowngraded()
	 */
	@Test
	public void testCanBeDowngraded(){
		//Player owns no blue fields
		assertThat(hvid.canBeDowngraded()).isFalse();

		//Player owns 1 blue field
		hvid.getDeed().setOwner(p1);
		assertThat(hvid.canBeDowngraded()).isFalse();

		//Player owns all blue fields, but none upgraded
		roed.getDeed().setOwner(p1);
		assertThat(hvid.canBeDowngraded()).isFalse();
		assertThat(roed.canBeDowngraded()).isFalse();

		//Upgrade to max and downgrade all the the way down
		for (int i = 0; i < roed.upgradeSignature.length-1; i++) {
			roed.upgrade();
			hvid.upgrade();
		}
		for (int i = 0; i < roed.upgradeSignature.length-2; i++) {
			roed.downgrade();
			hvid.downgrade();
			assertThat(hvid.canBeDowngraded()).isTrue();
			assertThat(roed.canBeDowngraded()).isTrue();
		}
		roed.downgrade();
		hvid.downgrade();
		assertThat(hvid.canBeDowngraded()).isFalse();
		assertThat(roed.canBeDowngraded()).isFalse();
	}

	/**
	 * @see Property#tryUpgrade()
	 */
	@Test
	public void testTryUpgrade(){
		//Where not possible
		assertThat(hvid.tryUpgrade()).isFalse();

		//Possible to upgrade
		hvid.getDeed().setOwner(p1);
		roed.getDeed().setOwner(p1);
		for (int i = 1; i < hvid.upgradeSignature.length; i++) {
			assertThat(hvid.tryUpgrade()).isTrue();
			assertThat(roed.tryUpgrade()).isTrue();
		}
		assertThat(hvid.tryUpgrade()).isFalse();
		assertThat(roed.tryUpgrade()).isFalse();
	}

	/**
	 * @see Property#tryDowngrade()
	 */
	@Test
	public void testTryDowngrade(){
		//Where not possible
		assertThat(hvid.tryUpgrade()).isFalse();

		//Possible to downgrade
		hvid.getDeed().setOwner(p1);
		roed.getDeed().setOwner(p1);
		for (int i = 1; i < hvid.upgradeSignature.length; i++) {
			hvid.upgrade();
			roed.upgrade();
		}
		for (int i = 0; i < hvid.upgradeSignature.length-1; i++) {
			assertThat(hvid.tryDowngrade()).isTrue();
			assertThat(roed.tryDowngrade()).isTrue();
		}

		//Cannot downgrade, but owns
		assertThat(hvid.tryDowngrade()).isFalse();
		assertThat(roed.tryDowngrade()).isFalse();

	}
}