package Finance;

import Game.Actions.DowngradeProperty;
import Game.Actions.EndActions;
import Game.Actions.SellDeedToBank;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonalAccountTest extends SmartTemplateTest {

	/**
	 * @see PersonalAccount#withdraw(int)
	 */
	@Test
	public void testWithdraw() {
		PersonalAccount account = (PersonalAccount) p1.getAccount();

		//Has enough money to withdraw
		account.withdraw(5000);
		assertThat(account.getBalance()).isEqualTo(5000);

		//Not enough money, but stuff to sell.
		bank.transferTradableTo(p1, hvid);
		gui.addActions(SellDeedToBank.self, hvid, EndActions.self);
		account.withdraw(5100);
		assertThat(account.getBalance()).isEqualTo(5000+840-5100);
		assertThat(hvid.getOwner()).isEqualTo(bank);

		//Property can be downgraded.
		bank.transferTradableTo(p1, roed);
		bank.transferTradableTo(p1, hvid);
		account.setBalance(10000);
		roed.getProperty().tryUpgrade();
		gui.addActions(DowngradeProperty.self, roed, EndActions.self);
		account.withdraw(9100);
		assertThat(account.getBalance()).isEqualTo(10000-1000+500-9100);

		//not enough money, lose game
		account.withdraw(1000000);
		assertThat(account.getBalance()).isEqualTo(0);
		assertThat(game.getLosers()).contains(p1);
		assertThat(game.getPlayers()).doesNotContain(p1);
	}

}