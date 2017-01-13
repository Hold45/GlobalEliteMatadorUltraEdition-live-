package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Game.Actions.Action;
import Game.DumTemplateTest;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest extends DumTemplateTest{


	/**
	 * Moving forward x field.
	 *
	 * @see Player#move(int)
	 */
	@Test
	public void testMoveToInt() {
		//Test if getting the 4000 for passing start.
		assertThat(p1.getPosition()).isEqualTo(0);
		p1.move(10);
		assertThat(p1.getAccount().getBalance()).isEqualTo(14000);
	}

	/**
	 * Moving forward to a specified field.
	 *
	 * @see Player#move(Field)
	 */
	@Test
	public void testMoveToField() {
		//Moving to field, passing start.
		p1.move(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(14000);

		//Moving to same field as standing on.
		p1.move(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(14000);

		//Moving all the way around.
	}

	/**
	 * @see Player#Move2()
	 */
	@Test
	public void testMove2() {

	}

	/**
	 * @see Player#GetOffsetPosition()
	 */
	@Test
	public void testGetOffsetPosition() {

	}

	/**
	 * @see Player#MoveTo()
	 */
	@Test
	public void testMoveTo() {

	}

	/**
	 * @see Player#GetNextFieldOfType()
	 */
	@Test
	public void testGetNextFieldOfType() {

	}

	/**
	 * @see Player#RollAndMove()
	 */
	@Test
	public void testRollAndMove() {

	}

	/**
	 * @see Player#GetPosition()
	 */
	@Test
	public void testGetPosition() {

	}

	/**
	 * @see Player#IsJailed()
	 */
	@Test
	public void testIsJailed() {

	}

	/**
	 * @see Player#Arrest()
	 */
	@Test
	public void testArrest() {

	}

	/**
	 * @see Player#Release()
	 */
	@Test
	public void testRelease() {

	}

	/**
	 * @see Player#GetName()
	 */
	@Test
	public void testGetName() {

	}

	/**
	 * @see Player#SetName()
	 */
	@Test
	public void testSetName() {

	}

	/**
	 * @see Player#ToString()
	 */
	@Test
	public void testToString() {

	}

	@Test
	public void testStartPosition(){
		assertThat(p1.getPosition()).isEqualTo(0);
	}


}