package Cards;

import Game.SmartTemplateTest;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CardPileTest extends SmartTemplateTest{

	/**
	 * @see CardPile#drawCard(Player)
	 */
	@Test
	public void testDrawCard() {
		cardPile.drawCard(p1); //Draws a gain1000
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000+1000);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000-1000);
	}

}