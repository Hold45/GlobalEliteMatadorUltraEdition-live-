package Owners;

import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.OrangePlots.Allegade;
import Board.Fields.Properties.Ships.HelsingoerHelsingborg;
import Game.Turns.RegularTurn;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class SmartPlayerTest extends SmartTemplateTest {
	@Test
	public void busTurnTest() {
		//Take an Bus turn.
		random.add(4, 3, 6);
		gui.addActions(game.getBoard().getField(Allegade.class), true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Allegade.class));
	}

	@Test
	public void normalTurnTest() {
		//Take an normal turn.
		random.add(5, 3, 2);
		int offset = p1.getOffsetPosition(10);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);
	}

	@Test
	public void MrMonopolyTurnTest() {
		//Take a Mr. Monopoly turn.
		random.add(2, 3, 4);
		int offset = p1.getOffsetPosition(5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);
	}

	@Test
	public void yahtzeeFromJailTest() {
		//Roll a yahtzee when in jail.
		p1.arrest();
		random.add(2, 2, 5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.isJailed()).isFalse();
	}

	@Test
	public void tripleRollTest() {
		//Take a triple turn
		random.add(2,2,2);
		gui.addActions(game.getBoard().getField(Hvidovrevej.class), true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
	}

	@Test
	public void takeExtraTurnOnDoubleRollTest() {
		random.add(2, 2, 1);
		gui.addActions(true, game.getBoard().getField(HelsingoerHelsingborg.class));
		p1.rollAndMove();
		assertThat(game.getTurns().pop()).isInstanceOf(RegularTurn.class);
	}
}
