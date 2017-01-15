package Board.Fields.Properties;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Ships.RoedbyPuttgarden;
import Board.Fields.Properties.Ships.Ship;
import Buildings.House;
import Game.SmartTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartPropertyTest extends SmartTemplateTest {
	private Property hvidClass;
	private Property roedClass;
	private Ship faerge;

	@Before
	public void setup(){
		hvidClass = (Property) game.getBoard().getField(game.getBoard().getIndex(Hvidovrevej.class));
		roedClass = (Property) game.getBoard().getField(game.getBoard().getIndex(Roedovrevej.class));
		faerge = (Ship) game.getBoard().getField(game.getBoard().getIndex(RoedbyPuttgarden.class));
	}

	@After
	public void tearDown(){
		hvidClass = null;
		roedClass = null;
	}

	/**
	 * @see Property#upgrade()
	 */
	 @Test
	 public void testUpgrade(){
		 for (int i = 1; i < hvidClass.upgradeSignature.length; i++) {
			 hvidClass.upgrade();
			 assertThat(hvidClass.getUpgradeValue()).isEqualTo(i);
		 }
	 }

	/**
	 * @see Property#tryDowngrade()
	 */
	 @Test
	 public void testDowngrade(){
		 for (int i = 1; i < hvidClass.upgradeSignature.length; i++)
			 hvidClass.upgrade();

		 for (int i = hvidClass.upgradeSignature.length-2; i >= 0 ; i--) {
			 hvidClass.downgrade();
			 assertThat(hvidClass.getUpgradeValue()).isEqualTo(i);
		 }
	 }

	/**
	 * @see Property#getUpgradeValue()
	 */
	@Test
	public void testGetUpgradeValue(){
		assertThat(hvidClass.getUpgradeValue()).isEqualTo(0);
		for (int i = 1; i < 5; i++) {
			hvidClass.getBuildings().add(new House());
			assertThat(hvidClass.getUpgradeValue()).isEqualTo(i);
		}
		assertThat(roedClass.getUpgradeValue()).isEqualTo(0);
		game.getBank().transferTradableTo(p1, roedClass.getDeed());
		assertThat(roedClass.getUpgradeValue()).isEqualTo(0);
		assertThat(faerge.getUpgradeValue()).isEqualTo(0);
	}

	/**
	 * @see Property#canBeUpgraded()
	 */
	@Test
	public void testCanBeUpgraded(){
		//Player owns no blue fields
		assertThat(hvidClass.canBeUpgraded()).isFalse();

		//Player owns 1 blue field
		hvidClass.getDeed().setOwner(p1);
		assertThat(hvidClass.canBeUpgraded()).isFalse();

		//Player owns all blue fields
		roedClass.getDeed().setOwner(p1);
		assertThat(hvidClass.canBeUpgraded()).isTrue();
		assertThat(roedClass.canBeUpgraded()).isTrue();

		//Upgrade to max and check if still upgradable
		for (int i = 0; i < roedClass.upgradeSignature.length-2; i++) {
			roedClass.upgrade();
			assertThat(roedClass.canBeUpgraded()).isFalse();
			hvidClass.upgrade();
			assertThat(hvidClass.canBeUpgraded()).isTrue();
			assertThat(roedClass.canBeUpgraded()).isTrue();
		}
		roedClass.upgrade();
		hvidClass.upgrade();
		assertThat(hvidClass.canBeUpgraded()).isFalse();
		assertThat(roedClass.canBeUpgraded()).isFalse();
	}

	/**
	 * @see Property#canBeDowngraded()
	 */
	@Test
	public void testCanBeDowngraded(){
		//Player owns no blue fields
		assertThat(hvidClass.canBeDowngraded()).isFalse();

		//Player owns 1 blue field
		hvidClass.getDeed().setOwner(p1);
		assertThat(hvidClass.canBeDowngraded()).isFalse();

		//Player owns all blue fields, but none upgraded
		roedClass.getDeed().setOwner(p1);
		assertThat(hvidClass.canBeDowngraded()).isFalse();
		assertThat(roedClass.canBeDowngraded()).isFalse();

		//Upgrade to max and downgrade all the the way down
		for (int i = 0; i < roedClass.upgradeSignature.length-1; i++) {
			roedClass.upgrade();
			hvidClass.upgrade();
		}
		for (int i = 0; i < roedClass.upgradeSignature.length-2; i++) {
			roedClass.downgrade();
			hvidClass.downgrade();
			assertThat(hvidClass.canBeDowngraded()).isTrue();
			assertThat(roedClass.canBeDowngraded()).isTrue();
		}
		roedClass.downgrade();
		hvidClass.downgrade();
		assertThat(hvidClass.canBeDowngraded()).isFalse();
		assertThat(roedClass.canBeDowngraded()).isFalse();
	}

	/**
	 * @see Property#tryUpgrade()
	 */
	@Test
	public void testTryUpgrade(){
		//Where not possible
		assertThat(hvidClass.tryUpgrade()).isFalse();

		//Possible to upgrade
		hvidClass.getDeed().setOwner(p1);
		roedClass.getDeed().setOwner(p1);
		for (int i = 1; i < hvidClass.upgradeSignature.length; i++) {
			assertThat(hvidClass.tryUpgrade()).isTrue();
			assertThat(roedClass.tryUpgrade()).isTrue();
			assertThat(p1.getAccount().getBalance()).isEqualTo(10000-(hvidClass.getDeed().getUpgradePrice()*2*i));
		}
		assertThat(hvidClass.tryUpgrade()).isFalse();
		assertThat(roedClass.tryUpgrade()).isFalse();
	}

	/**
	 * @see Property#tryDowngrade()
	 */
	@Test
	public void testTryDowngrade(){
		//Where not possible
		assertThat(hvidClass.tryUpgrade()).isFalse();

		//Possible to downgrade
		hvidClass.getDeed().setOwner(p1);
		roedClass.getDeed().setOwner(p1);
		for (int i = 1; i < hvidClass.upgradeSignature.length; i++) {
			hvidClass.upgrade();
			roedClass.upgrade();
		}
		for (int i = 0; i < hvidClass.upgradeSignature.length-1; i++) {
			assertThat(hvidClass.tryDowngrade()).isTrue();
			assertThat(roedClass.tryDowngrade()).isTrue();
		}

		//Cannot downgrade, but owns
		assertThat(hvidClass.tryDowngrade()).isFalse();
		assertThat(roedClass.tryDowngrade()).isFalse();

	}
}