package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Plots.Plot;
import Game.SmartTemplateTest;
import Owners.Accountable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeedTest extends SmartTemplateTest{
	private Deed hvidovrevej;
	private Deed roedovrevej;

	@Before
	public void setup(){
		hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		roedovrevej = ((Plot) game.getBoard().getField(Roedovrevej.class)).getDeed();
	}

	@After
	public void tearDown(){
		hvidovrevej = null;
		roedovrevej = null;
	}

	/**
	 * Test whether can be traded works as intended.
	 *
	 * @see Deed#canBePawned()
	 */
	@Test
	public void testCanBeTraded() throws Exception {
		//Can be traded when not pawned and no buildings on other types.
		assertThat(hvidovrevej.canBeTraded()).isTrue();

		//Cannot be traded when building on other type of blue.
		roedovrevej.getProperty().upgrade();
		assertThat(hvidovrevej.canBeTraded()).isFalse();

		//Cannot be traded when deed is pawned.
		roedovrevej.getProperty().downgrade();
		hvidovrevej.tryPurchase(p1);
		hvidovrevej.pawn();
		assertThat(hvidovrevej.canBeTraded()).isFalse();
	}

	/**
	 * Test if canBePawned works correctly.
	 *
	 * @see Deed#canBePawned()
	 * @see DeedTest#testCanBeTraded()
	 * @see DeedTest#testIsPlayerOwned()
	 */
	@Test
	public void testCanBePawned() {
		//Cannot be pawned if owned by bank.
		assertThat(hvidovrevej.canBePawned()).isFalse();

		//can be pawned if tradable and owned by player.
		hvidovrevej.setOwner(p1);
		assertThat(hvidovrevej.canBePawned()).isTrue();

		//cannot be pawned if already pawned.
		hvidovrevej.pawn();
		assertThat(hvidovrevej.canBePawned()).isFalse();
	}

	/**
	 * Check if a deed can be unpawned.
	 *
	 * @see Deed#canBeUnpawned()
	 * @see DeedTest#testIsPlayerOwned()
	 */
	@Test
	public void testCanBeUnpawned(){
		hvidovrevej.setOwner(p1);
		hvidovrevej.pawn();

		//Not enough money to unpawn.
		p1.getAccount().setBalance(0);
		assertThat(hvidovrevej.canBeUnpawned()).isFalse();

		//Enough money to unpawn.
		p1.getAccount().setBalance(10000);
		assertThat(hvidovrevej.canBeUnpawned()).isTrue();
	}

	/**
	 *
	 * @see Deed#isPlayerOwned()
	 */
	@Test
	public void testIsPlayerOwned() throws Exception {
		//False as default is owned by bank.
		assertThat(hvidovrevej.isPlayerOwned()).isFalse();

		//Is owned by player
		hvidovrevej.setOwner(p1);
		assertThat(hvidovrevej.isPlayerOwned()).isTrue();
	}

	/**
	 * Checks if pawn works correctly, this does not check if it's pawnable also.
	 *
	 * @see Deed#pawn()
	 * @see Deed#canBePawned()
	 */
	@Test
	public void testPawn() throws Exception {
		hvidovrevej.setOwner(p1);
		p1.getAccount().setBalance(0);

		//Pawn the deed
		hvidovrevej.pawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo(hvidovrevej.getPrice()/2);
		assertThat(hvidovrevej.isPawned()).isTrue();
	}

	/**
	 * Checks if unpawning is successful, this does not check if the deed is unpawnable.
	 *
	 * @see Deed#unPawn()
	 * @see Deed#canBeUnpawned()
	 */
	@Test
	public void testUnPawn() throws Exception {
		hvidovrevej.setOwner(p1);
		hvidovrevej.pawn();
		int balance = p1.getAccount().getBalance();

		//Unpawn the deed.
		hvidovrevej.unPawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo((int) (balance-hvidovrevej.getPrice()*0.55));
		assertThat(hvidovrevej.isPawned()).isFalse();
	}

	/**
	 * Checks if purchasing is successful, this does not check if the deed is purchasable.
	 *
	 * @see Deed#purchase(Accountable, int)
	 * @see Deed#purchase(Accountable)
	 */
	@Test
	public void testPurchase() {
		assertThat(bank.getOwns()).contains(hvidovrevej);
		assertThat(bank.getOwns()).contains(roedovrevej);

		//Purchase for the price of the deed.
		p1.getAccount().setBalance(1200);
		hvidovrevej.purchase(p1);
		assertThat(p1.getOwns()).contains(hvidovrevej);
		assertThat(p1.getAccount().getBalance()).isEqualTo(0);
		assertThat(bank.getOwns()).doesNotContain(hvidovrevej);

		//Purchase for a specified price.
		p1.getAccount().setBalance(10000);
		roedovrevej.purchase(p1, 5000);
		assertThat(p1.getOwns()).contains(roedovrevej);
		assertThat(p1.getAccount().getBalance()).isEqualTo(5000);
		assertThat(bank.getOwns()).doesNotContain(roedovrevej);
	}

	/**
	 * Checks if purchasable returns true when needed.
	 *
	 * @see Deed#isPurchasable(Accountable, int)
	 */
	@Test
	public void testIsPurchasable(){
		//Is not owner, but does not have enough money.
		assertThat(hvidovrevej.isPurchasable(p1, 11000)).isFalse();

		//Has enough money and is not owner.
		assertThat(hvidovrevej.isPurchasable(p1, 1000)).isTrue();

		//has enough money but is owner.
		hvidovrevej.setOwner(p1);
		assertThat(hvidovrevej.isPurchasable(p1, 1000)).isFalse();
	}

	/**
	 * Tests auktioning of a tradable
	 *
	 * @see Cards.Tradable#auctionOff(int, int)
	 */
	@Test
	public void testAuctionOff(){
		assertThat(hvidovrevej.getOwner()).isEqualTo(game.getBank());
		gui.addActions(false, false); //Both players decline to bid
		hvidovrevej.auctionOff(100, 10);
		assertThat(hvidovrevej.getOwner()).isEqualTo(game.getBank());
		gui.addActions(true, 10, false); //Only first player bids
		hvidovrevej.auctionOff(100, 10);
		assertThat(hvidovrevej.getOwner()).isEqualTo(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-110);
		assertThat(game.getBank().getAccount().getBalance()).isEqualTo(10000+110);
		assertThat(roedovrevej.getOwner()).isEqualTo(game.getBank());
		gui.addActions(true, 10, true, 10, false); //Both players bid, with first player declining to raise
		roedovrevej.auctionOff(100, 10);
		assertThat(roedovrevej.getOwner()).isEqualTo(p2);
		assertThat(p2.getAccount().getBalance()).isEqualTo(10000-120);
	}

}