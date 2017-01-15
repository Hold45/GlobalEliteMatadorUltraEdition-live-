package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Molslinien;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MoveToMolsLinienTest extends CardTemplateTest{

	@Override
	public void setup() {
		card = new MoveToMolsLinien(cardPile);
	}

	/**
	 * @see MoveToMolsLinien
	 */
	@Test
	public void testDraw() {
		card.draw(p1);
		assertThat(p1.getPosition()).isEqualTo(board.getIndex(Molslinien.class));
	}
}