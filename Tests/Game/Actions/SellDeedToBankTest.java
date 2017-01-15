package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Game.SmartTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SellDeedToBankTest extends SmartTemplateTest{
	private Action sellDeedToBank;

	@Before
	public void setup(){
		sellDeedToBank = SellDeedToBank.self;
	}

	/**
	 * @see SellDeedToBank
	 */
	@Test
	public void testRun() {
		gui.addActions(hvid);
		hvid.tryPurchase(p1);
		sellDeedToBank.run(p1);
		assertThat(p1.getOwns()).doesNotContain(hvid);
		assertThat(bank.getOwns()).contains(hvid);
	}

	/**
	 * @see SellDeedToBank
	 */
	@Test
	public void testRunnable() {
		//No deeds to sell.
		assertThat(sellDeedToBank.runnable(p1)).isFalse();

		//Deeds to sell
		hvid.tryPurchase(p1);
		assertThat(sellDeedToBank.runnable(p1)).isTrue();
	}
}