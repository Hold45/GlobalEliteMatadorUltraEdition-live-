package Owners;

import Board.Fields.Properties.Plots.OrangePlots.Allegade;
import GUI.SmartGUI;
import Game.SmartTemplateTest;
import org.junit.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

/**
 *
 */
public class SmartPlayerTest extends SmartTemplateTest {
	@Test
	public void testRollAndMove(){
		//Take an Bus turn.
		gui.addActions(true, game.getBoard().getField(Allegade.class));
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Allegade.class));

		//Take an Mr. Monopoly turn.
		int offset = p1.getOffsetPosition(5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);

		//Take an normal turn.
		offset = p1.getOffsetPosition(10);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);
	}
}
