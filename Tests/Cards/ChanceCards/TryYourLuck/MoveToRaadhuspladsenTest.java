package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToRaadhuspladsenTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToRaadhuspladsen(cardPile);
	}

	/**
	 * @see MoveToRaadhuspladsen#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(Raadhuspladsen.class));
	}
}