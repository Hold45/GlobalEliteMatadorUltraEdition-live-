package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.RoedbyPuttgarden;
import Board.Fields.Properties.Ships.Ship;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToShipX2Test extends CardTemplateTest {

	@Override
	public void setup() {
		card = new MoveToShipX2(cardPile);
	}

	/**
	 * @see MoveToShipX2#draw(Player)
	 */
	@Test
	public void testDraw() {
		int shipIndex = board.getIndex(Ship.class);
		int balance = p1.getAccount().getBalance();
		Ship ship = (Ship) board.getField(shipIndex);

		//go to ship without owner and buy it.
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(shipIndex);
		assertThat(((Ship)board.getField(p1.getPosition())).getDeed().getOwner()).isEqualTo(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(balance-4000); //price of ship
		balance = p1.getAccount().getBalance();

		//Go to ship while owning it.
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(shipIndex);
		assertThat(p1.getAccount().getBalance()).isEqualTo(balance+4000); //Money for passing start.
		balance = p1.getAccount().getBalance();

		//Go to ship while other play owns it.
		p1.transferTradableTo(p2, ship.getDeed());
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(shipIndex);
		assertThat(p1.getAccount().getBalance()).isEqualTo(balance+4000-1000); //4000 for passing start and 1000 for double rent.
		balance = p1.getAccount().getBalance();

		//Go to ship while other player owns it and another ship...
		((Ship) board.getField(RoedbyPuttgarden.class)).getDeed().tryPurchase(p2, 0);
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(shipIndex);
		assertThat(p1.getAccount().getBalance()).isEqualTo(balance+4000-2000); //4000 for passing start and 2000 for double rent with 2 ships.

	}

}