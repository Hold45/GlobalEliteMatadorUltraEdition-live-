package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Pay2000Test extends CardTemplateTest{

	@Override
	public void setup() {
		card = new Pay2000(cardPile);
	}

	/**
	 * @see Pay2000#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-2000);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000+2000);
	}

}