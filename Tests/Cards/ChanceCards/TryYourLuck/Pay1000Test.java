package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Pay1000Test extends CardTemplateTest {

	@Override
	public void setup() {
		card = new Pay1000(cardPile);
	}

	/**
	 * @see Pay1000#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1000);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000+1000);
	}
}