package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.RedPlots.Groenningen;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToGroenningenTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToGroenningen(cardPile);
	}

	/**
	 * @see MoveToGroenningen#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(Groenningen.class));
	}

}