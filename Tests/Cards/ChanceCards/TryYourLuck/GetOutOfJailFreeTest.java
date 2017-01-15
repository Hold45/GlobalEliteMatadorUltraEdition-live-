package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GetOutOfJailFreeTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new GetOutOfJailFree(cardPile);
		cardPile.addTradable(card);
	}

	/**
	 * @see GetOutOfJailFree#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		System.out.println(p1.getOwns());
		assertThat(p1.getOwns()).contains(card);
		assertThat(cardPile.getOwns()).doesNotContain(card);
	}

	/**
	 * @see GetOutOfJailFree#play()
	 */
	@Test
	public void testPlay() {
		//Test if releasing
		p1.arrest();
		card.draw(p1);
		card.play();
		assertThat(p1.isJailed()).isFalse();
	}

	/**
	 * @see GetOutOfJailFree#canBeTraded()
	 */
	@Test
	public void testCanBeTraded() {
		assertThat(card.canBeTraded()).isTrue();
	}

	/**
	 * @see GetOutOfJailFree#canBePlayed()
	 */
	@Test
	public void testCanBePlayed() {
		//Owned by card pile.
		assertThat(card.canBePlayed()).isFalse();

		//Owned by player, but not jailed.
		card.draw(p1);
		assertThat(card.canBePlayed()).isFalse();

		//Owned by player and jailed.
		p1.arrest();
		assertThat(card.canBePlayed()).isTrue();

	}
}