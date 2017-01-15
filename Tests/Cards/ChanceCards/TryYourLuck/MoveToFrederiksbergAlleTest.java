package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.GreenPlots.FrederiksbergAlle;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToFrederiksbergAlleTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToFrederiksbergAlle(cardPile);
	}

	/**
	 * @see MoveToFrederiksbergAlle#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(FrederiksbergAlle.class));
	}

}