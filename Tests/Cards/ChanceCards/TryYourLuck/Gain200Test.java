package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Game.SmartTemplateTest;
import Owners.Player;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Gain200Test extends SmartTemplateTest {
	ChanceCard card;

	@Before
	public void setup(){
		card = new Gain200(game.getCardPile());
	}

	@After
	public void tearDown(){
		card = null;
	}

	/**
	 * @see Gain200#draw(Player)
	 */
	@Test
	public void testDraw() {
	}
}