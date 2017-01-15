package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Gain200Test extends CardTemplateTest {

	public void setup(){
		card = new Gain200(cardPile);
	}

	/**
	 * @see Gain200#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000+200);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000-200);
	}
}