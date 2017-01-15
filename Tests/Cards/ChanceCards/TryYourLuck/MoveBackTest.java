package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveBackTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveBack(cardPile);
	}

	/**
	 * @see MoveBack#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getFields().length-3);
	}

}