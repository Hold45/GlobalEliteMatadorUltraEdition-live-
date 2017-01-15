package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Game.DumTemplateTest;
import org.junit.After;
import org.junit.Before;

public abstract class CardTemplateTest extends DumTemplateTest{
	ChanceCard card;

	@Before
	public abstract void setup();

	@After
	public void tearDown(){
		card = null;
	}
}
