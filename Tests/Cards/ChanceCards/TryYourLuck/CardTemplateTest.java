package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Game.DumTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public abstract class CardTemplateTest extends DumTemplateTest{
	ChanceCard card;

	@Before
	public abstract void setup();

	@After
	public void tearDown(){
		card = null;
	}

	@Test
	public void testCanBePlayed(){
		assertThat(card.canBePlayed()).isFalse();
	}

	@Test
	public void testCanBeTraded(){
		assertThat(card.canBeTraded()).isFalse();
	}

	@Test
	public void testGetPrice() {
		assertThat(card.getPrice()).isEqualTo(0);
	}
}
