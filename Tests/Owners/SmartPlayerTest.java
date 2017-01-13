package Owners;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.OrangePlots.Allegade;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class SmartPlayerTest extends SmartTemplateTest {
	@Test
	public void testRollAndMove(){
		//Take an Bus turn.
		random.add(4,3,6);
		gui.addActions(true, game.getBoard().getField(Allegade.class));
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Allegade.class));

		//Take an normal turn.
		random.add(5,3,2);
		int offset = p1.getOffsetPosition(10);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);

		//Take a Mr. Monopoly turn.
		random.add(2,3,4);
		offset = p1.getOffsetPosition(5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);

		//Roll a yahtzee when in jail.
		p1.arrest();
		random.add(2,2,5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.isJailed()).isFalse();

		//Take a triple turn
		random.add(2,2,2);
		gui.addActions(true, game.getBoard().getField(Hvidovrevej.class));
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
	}
}
