package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaftet;
import Owners.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToVimmelskaftetTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToVimmelskaftet(cardPile);
	}


	/**
	 * @see MoveToVimmelskaftet#draw(Player)
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(Vimmelskaftet.class));
	}
}