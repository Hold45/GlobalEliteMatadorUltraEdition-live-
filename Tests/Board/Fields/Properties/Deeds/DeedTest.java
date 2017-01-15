package Board.Fields.Properties.Deeds;

import Game.SmartTemplateTest;
import Owners.Accountable;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeedTest extends SmartTemplateTest{

	/**
	 * Test whether can be traded works as intended.
	 *
	 * @see Deed#canBePawned()
	 */
	@Test
	public void testCanBeTraded() throws Exception {
		//Can be traded when not pawned and no buildings on other types.
		assertThat(hvid.canBeTraded()).isTrue();

		//Cannot be traded when building on other type of blue.
		roed.getProperty().upgrade();
		assertThat(hvid.canBeTraded()).isFalse();

		//Cannot be traded when deed is pawned.
		roed.getProperty().downgrade();
		hvid.tryPurchase(p1);
		hvid.pawn();
		assertThat(hvid.canBeTraded()).isFalse();
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
		assertThat(hvid.canBePawned()).isFalse();

		//can be pawned if tradable and owned by player.
		hvid.setOwner(p1);
		assertThat(hvid.canBePawned()).isTrue();

		//cannot be pawned if already pawned.
		hvid.pawn();
		assertThat(hvid.canBePawned()).isFalse();
	}

	/**
	 * Check if a deed can be unpawned.
	 *
	 * @see Deed#canBeUnpawned()
	 * @see DeedTest#testIsPlayerOwned()
	 */
	@Test
	public void testCanBeUnpawned(){
		hvid.setOwner(p1);
		hvid.pawn();

		//Not enough money to unpawn.
		p1.getAccount().setBalance(0);
		assertThat(hvid.canBeUnpawned()).isFalse();

		//Enough money to unpawn.
		p1.getAccount().setBalance(10000);
		assertThat(hvid.canBeUnpawned()).isTrue();
	}

	/**
	 *
	 * @see Deed#isPlayerOwned()
	 */
	@Test
	public void testIsPlayerOwned() throws Exception {
		//False as default is owned by bank.
		assertThat(hvid.isPlayerOwned()).isFalse();

		//Is owned by player
		hvid.setOwner(p1);
		assertThat(hvid.isPlayerOwned()).isTrue();
	}

	/**
	 * Checks if pawn works correctly, this does not check if it's pawnable also.
	 *
	 * @see Deed#pawn()
	 * @see Deed#canBePawned()
	 */
	@Test
	public void testPawn() throws Exception {
		hvid.setOwner(p1);
		p1.getAccount().setBalance(0);

		//Pawn the deed
		hvid.pawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo(hvid.getPrice()/2);
		assertThat(hvid.isPawned()).isTrue();
	}

	/**
	 * Checks if unpawning is successful, this does not check if the deed is unpawnable.
	 *
	 * @see Deed#unPawn()
	 * @see Deed#canBeUnpawned()
	 */
	@Test
	public void testUnPawn() throws Exception {
		hvid.setOwner(p1);
		hvid.pawn();
		int balance = p1.getAccount().getBalance();

		//Unpawn the deed.
		hvid.unPawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo((int) (balance-hvid.getPrice()*0.55));
		assertThat(hvid.isPawned()).isFalse();
	}

	/**
	 * Checks if purchasing is successful, this does not check if the deed is purchasable.
	 *
	 * @see Deed#purchase(Accountable, int)
	 * @see Deed#purchase(Accountable)
	 */
	@Test
	public void testPurchase() {
		assertThat(bank.getOwns()).contains(hvid);
		assertThat(bank.getOwns()).contains(roed);

		//Purchase for the price of the deed.
		p1.getAccount().setBalance(1200);
		hvid.purchase(p1);
		assertThat(p1.getOwns()).contains(hvid);
		assertThat(p1.getAccount().getBalance()).isEqualTo(0);
		assertThat(bank.getOwns()).doesNotContain(hvid);

		//Purchase for a specified price.
		p1.getAccount().setBalance(10000);
		roed.purchase(p1, 5000);
		assertThat(p1.getOwns()).contains(roed);
		assertThat(p1.getAccount().getBalance()).isEqualTo(5000);
		assertThat(bank.getOwns()).doesNotContain(roed);
	}

	/**
	 * Checks if purchasable returns true when needed.
	 *
	 * @see Deed#isPurchasable(Accountable, int)
	 */
	@Test
	public void testIsPurchasable(){
		//Is not owner, but does not have enough money.
		assertThat(hvid.isPurchasable(p1, 11000)).isFalse();

		//Has enough money and is not owner.
		assertThat(hvid.isPurchasable(p1, 1000)).isTrue();

		//has enough money but is owner.
		hvid.setOwner(p1);
		assertThat(hvid.isPurchasable(p1, 1000)).isFalse();
	}

	/**
	 * Tests auktioning of a tradable
	 *
	 * @see Cards.Tradable#auctionOff(int, int)
	 */
	@Test
	public void testAuctionOff(){
		assertThat(hvid.getOwner()).isEqualTo(game.getBank());
		gui.addActions(false, false); //Both players decline to bid
		hvid.auctionOff(100, 10);
		assertThat(hvid.getOwner()).isEqualTo(game.getBank());
		gui.addActions(true, 10, false); //Only first player bids
		hvid.auctionOff(100, 10);
		assertThat(hvid.getOwner()).isEqualTo(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-110);
		assertThat(game.getBank().getAccount().getBalance()).isEqualTo(10000+110);
		assertThat(roed.getOwner()).isEqualTo(game.getBank());
		gui.addActions(true, 10, true, 10, false); //Both players bid, with first player declining to raise
		roed.auctionOff(100, 10);
		assertThat(roed.getOwner()).isEqualTo(p2);
		assertThat(p2.getAccount().getBalance()).isEqualTo(10000-120);
	}

}