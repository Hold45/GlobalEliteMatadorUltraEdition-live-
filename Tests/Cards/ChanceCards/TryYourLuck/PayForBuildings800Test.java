package Cards.ChanceCards.TryYourLuck;

import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PayForBuildings800Test extends CardTemplateTest{

	@Override
	public void setup() {
		card = new PayForBuildings800(cardPile);
	}

	/**
	 * @see PayForBuildings800#draw(Player)
	 */
	@Test
	public void testDraw() {
		//No buildings
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000);

		//1 house
		bank.transferTradableTo(p1, roed);
		roed.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-800);

		//2 houses.
		roed.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1600);

		//3 houses.
		roed.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-2400);

		//4 houses.
		roed.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-3200);

		//1 hotel
		roed.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-2300);

		bank.transferTradableTo(p1, hvid);
		hvid.getProperty().upgrade();
		p1.getAccount().setBalance(10000);
		card.draw(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-3100);
	}
}