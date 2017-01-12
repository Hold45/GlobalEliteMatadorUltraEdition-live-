package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Plots.Plot;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DeedTest extends SmartTemplateTest{


	/**
	 * Test whether can be traded works as intended.
	 *
	 * @see Deed#canBePawned()
	 */
	@Test
	public void testCanBeTraded() throws Exception {
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		Deed roedovrevej = ((Plot) game.getBoard().getField(Roedovrevej.class)).getDeed();

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
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();

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
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
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
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();

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
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		hvidovrevej.setOwner(p1);
		p1.getAccount().setBalance(0);

		//Pawn the deed
		hvidovrevej.pawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo(hvidovrevej.getPrice()/2);
		assertThat(hvidovrevej.isPawned()).isTrue();
	}

	/**
	 * Only pawns the deed if can be pawned is true.
	 *
	 * @see Deed#tryPawn()
	 * @see Deed#pawn()
	 * @see Deed#canBePawned()
	 * @see DeedTest#testPawn()
	 */
	@Test
	public void testTryPawn() throws Exception {

	}

	/**
	 * Checks if unpawning is successful, this does not check if the deed is unpawnable.
	 *
	 * @see Deed#unPawn()
	 * @see Deed#canBeUnpawned()
	 */
	@Test
	public void testUnPawn() throws Exception {
		Deed hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		hvidovrevej.setOwner(p1);
		hvidovrevej.pawn();
		int balance = p1.getAccount().getBalance();

		//Unpawn the deed.
		hvidovrevej.unPawn();
		assertThat(p1.getAccount().getBalance()).isEqualTo((int) (balance-hvidovrevej.getPrice()*0.55));
		assertThat(hvidovrevej.isPawned()).isFalse();
	}

}