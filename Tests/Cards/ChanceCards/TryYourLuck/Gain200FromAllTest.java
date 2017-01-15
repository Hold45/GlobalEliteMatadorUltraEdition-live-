package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Gain200FromAllTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new Gain200FromAll(cardPile);
	}

	/**
	 * @see Gain200FromAll#draw(Player)
	 */
	@Test
	public void testDraw() {
		//Draw from other players, with 1 other player
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000+200);
		assertThat(p2.getAccount().getBalance()).isEqualTo(10000-200);
		assertThat(bank.getAccount().getBalance()).isEqualTo(10000);

		//Draw from 2 other players
		Player p3 = new Player(game);
		p3.getAccount().setBalance(10000);
		game.addPlayers(p3);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000+(3*200));
		assertThat(p2.getAccount().getBalance()).isEqualTo(10000-(2*200));
		assertThat(p3.getAccount().getBalance()).isEqualTo(10000-200);
	}

}