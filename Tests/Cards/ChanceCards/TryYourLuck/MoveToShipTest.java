package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToShipTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToShip(cardPile);
	}

	/**
	 * @see MoveToShip#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(Ship.class));
	}
}