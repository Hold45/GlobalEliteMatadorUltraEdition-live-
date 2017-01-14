package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Property;
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
		//Test if getting the 4000 for passing setup.
		assertThat(p1.getPosition()).isEqualTo(0);
		p1.moveTo(Start.class);
		p1.moveTo(Start.class);
		assertThat(p1.getAccount().getBalance()).isEqualTo(14000);
	}

	/**
	 * Moving forward to a specified field.
	 *
	 * @see Player#moveTo(Field)
	 */
	@Test
	public void testMoveToField() {
		//Moving to field, passing setup first time.
		gui.addActions(true);
		p1.moveTo(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200); //pay for purchasing Hvidovrevej.

		//Moving to same field as standing on. Means moving all the way around
		p1.moveTo(game.getBoard().getField(Hvidovrevej.class));
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200+4000);
	}

	/**
	 * Moving forward to a specified class
	 *
	 * @see Player#moveTo(Class)
	 */
	@Test
	public void testMoveToClass() {
		//Moving to field, passing setup first time.
		gui.addActions(true);
		p1.moveTo(Hvidovrevej.class);
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
		assertThat(p1.getAccount().getBalance()).isEqualTo(10000-1200); //pay for purchasing Hvidovrevej.

		//Moving to same field as standing on. Means moving all the way around
		p1.moveTo(Hvidovrevej.class);
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

	@Test
	public void testLose(){
		Player p3 = new Player(game, "Player 3");
		p3.getAccount().setBalance(10000);
		game.addPlayers(p3);
		Deed hvid = ((Property) game.getBoard().getField(game.getBoard().getIndex(Hvidovrevej.class))).getDeed();
		game.getBank().transferTradableTo(p1, hvid);
		assertThat(hvid.getOwner()).isEqualTo(p1);
		assertThat(game.getPlayers().contains(p1)).isTrue();
		gui.addActions(false, true, 100);
		p1.lose();
		assertThat(game.getPlayers().contains(p1)).isFalse();
		assertThat(hvid.getOwner()).isEqualTo(p3);
		assertThat(p3.getAccount().getBalance()).isEqualTo(10000-200);
		assertThat(game.getBank().getAccount().getBalance()).isEqualTo(10000+10000+200);
		// The original money from the bank, plus the money from the player who lost,
		// plus the money gained from auctionong the deed.
	}
}