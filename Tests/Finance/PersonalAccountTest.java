package Finance;

import Game.Actions.DowngradeProperty;
import Game.Actions.EndActions;
import Game.Actions.SellDeedToBank;
import Game.SmartTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonalAccountTest extends SmartTemplateTest {
	private PersonalAccount account;

	@Before
	public void setup() {
		account = (PersonalAccount) p1.getAccount();
	}

	@After
	public void teardown() {
		account = null;
	}

	/**
	 * @see PersonalAccount#withdraw(int)
	 */
	@Test
	public void testWithdraw() {

		//Has enough money to withdraw
		account.withdraw(5000);
		assertThat(account.getBalance()).isEqualTo(5000);

		//Not enough money, but stuff to sell.
		bank.transferTradableTo(p1, hvid);
		gui.addActions(SellDeedToBank.self, hvid, EndActions.self);
		account.withdraw(5100);
		assertThat(account.getBalance()).isEqualTo(5000 + 840 - 5100);
		assertThat(hvid.getOwner()).isEqualTo(bank);

		//Property can be downgraded.
		bank.transferTradableTo(p1, roed);
		bank.transferTradableTo(p1, hvid);
		account.setBalance(10000);
		roed.getProperty().tryUpgrade();
		gui.addActions(DowngradeProperty.self, roed, EndActions.self);
		account.withdraw(9100);
		assertThat(account.getBalance()).isEqualTo(10000 - 1000 + 500 - 9100);
//	}
//
//	@Test
//	public void withdrawTooMuchTest(){
//		//not enough money, lose game
		gui.addActions(EndActions.self);
		account.withdraw(1000000);
		assertThat(account.getBalance()).isEqualTo(0);
		assertThat(game.getLosers()).contains(p1);
		assertThat(game.getPlayers()).doesNotContain(p1);
	}

}