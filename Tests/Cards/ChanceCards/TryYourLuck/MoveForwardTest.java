package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveForwardTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveForward(cardPile);
	}

	/**
	 * @see MoveForward#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(3);
	}

}