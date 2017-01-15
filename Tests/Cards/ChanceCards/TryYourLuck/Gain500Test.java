package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Gain500Test extends CardTemplateTest{

	@Override
	public void setup() {
		card = new Gain500(cardPile);
	}

	/**
	 * @see Gain500#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000+500);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000-500);
	}
}