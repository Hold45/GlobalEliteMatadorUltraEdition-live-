package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Pay3000Test extends CardTemplateTest{

	@Override
	public void setup() {
		card = new Pay3000(cardPile);
	}

	/**
	 * @see Pay3000#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-3000);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000+3000);
	}
}