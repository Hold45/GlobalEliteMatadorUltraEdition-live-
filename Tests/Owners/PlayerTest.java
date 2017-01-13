package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Start;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest extends SmartTemplateTest{


	/**
	 * Moving forward x field.
	 *
	 * @see Player#move(int)
	 */
	@Test
	public void testMoveToInt() {
		//Test if getting the 4000 for passing start.
		assertThat(p1.getPosition()).isEqualTo(0);
		p1.move(Start.class);
		p1.move(Start.class);
		assertThat(p1.getAccount().getBalance()).isEqualTo(14000);
	}

	/**
	 * Moving forward to a specified field.
	 *
	 * @see Player#move(Field)
	 */
	@Test
	public void testMoveToField() {
		//Moving to field, passing start first time.
		gui.addActions(true);
		p1.move(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200); //pay for purchasing Hvidovrevej.

		//Moving to same field as standing on. Means moving all the way around
		p1.move(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200+4000);
	}

	/**
	 * Moving forward to a specified class
	 *
	 * @see Player#move(Class)
	 */
	@Test
	public void testMoveToClass() {
		//Moving to field, passing start first time.
		gui.addActions(true);
		p1.move(Hvidovrevej.class);
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200); //pay for purchasing Hvidovrevej.

		//Moving to same field as standing on. Means moving all the way around
		p1.move(Hvidovrevej.class);
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200+4000);
	}

	/**
	 * @see Player#getOffsetPosition(int)
	 */
	@Test
	public void testGetOffsetPosition() {
		//Move forwards
		assertThat(p1.getOffsetPosition(10)).isEqualTo(10);

		//Move more than a board forward.
		assertThat(p1.getOffsetPosition(game.getBoard().getFields().length*2)).isEqualTo(0);

		//Move backwards
		assertThat(p1.getOffsetPosition(-1)).isEqualTo(game.getBoard().getFields().length-1);

		//Move backwards more than a board length.
		assertThat(p1.getOffsetPosition(-(game.getBoard().getFields().length*2))).isEqualTo(0);
	}



	/**
	 * @see Player#toString()
	 */
	@Test
	public void testToString() {
		assertThat(p1.toString()).isEqualTo(p1.getName());
	}

	@Test
	public void testStartPosition(){
		assertThat(p1.getPosition()).isEqualTo(0);
	}


}