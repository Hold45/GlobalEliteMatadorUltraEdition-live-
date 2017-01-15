package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.OrangePlots.Allegade;
import Board.Fields.Properties.Property;
import Board.Fields.Properties.Ships.HelsingoerHelsingborg;
import Board.Fields.Start;
import Game.SmartTemplateTest;
import Game.Turns.RegularTurn;
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

	@Test
	public void getPlayersTest(){
		assertThat(game.getPlayers().get(0)).isEqualTo(p1);
		assertThat(game.getPlayers(p2).get(0)).isEqualTo(p2);
	}

	/**
	 * @see Player#toString()
	 */
	@Test
	public void testToString() {
		assertThat(p1.toString()).isEqualTo(p1.getName());

		//change name and test tostring
		p1.setName("new name");
		assertThat(p1.toString()).isEqualTo("new name");
	}

	@Test
	public void testStartPosition(){
		assertThat(p1.getPosition()).isEqualTo(0);
	}

	/**
	 * Test whether the losing player is successfully removed from the game,
	 * and their funds are distributed and auctioned off correctly.
	 *
	 */
	@Test
	public void testLose(){
		Player p3 = new Player(game, "Player 3");
		p3.getAccount().setBalance(10000);
		game.addPlayers(p3);
		game.getBank().transferTradableTo(p1, hvid);
		assertThat(hvid.getOwner()).isEqualTo(p1);
		assertThat(game.getPlayers().contains(p1)).isTrue();
		gui.addActions(false, true, 100);
		p1.lose();
		assertThat(game.getPlayers().contains(p1)).isFalse();
		assertThat(hvid.getOwner()).isEqualTo(p3);
		assertThat(p3.getAccount().getBalance()).isEqualTo(10000-200);
		assertThat(game.getBank().getAccount().getBalance()).isEqualTo(10000+200);
		// The original money from the bank plus the money gained from auctioning the deed.
		// The rest of the players money disappears. In a normal game, they till be transferred to someone else.
	}

	@Test
	public void testLoseWithPawnedDeed() {
		Player p3 = new Player(game, "Player 3");
		p3.getAccount().setBalance(10000);
		game.addPlayers(p3);
		game.getBank().transferTradableTo(p1, hvid);
		assertThat(hvid.getOwner()).isEqualTo(p1);
		hvid.tryPawn();
		assertThat(game.getPlayers().contains(p1)).isTrue();
		gui.addActions(false, true, 100);
		p1.lose();
		assertThat(game.getPlayers().contains(p1)).isFalse();
		assertThat(hvid.getOwner()).isEqualTo(p3);
		assertThat(p3.getAccount().getBalance()).isEqualTo(10000-200);
		assertThat(game.getBank().getAccount().getBalance()).isEqualTo(10000+200+60);
		// Bank has the original money, plus the money from the auction,
		// plus the money gained from p1 pawning and unpawning hvid.

	}

	@Test
	public void testBusTurn() {
		//Take an Bus turn.
		random.add(4, 3, 6);
		gui.addActions(game.getBoard().getField(Allegade.class), true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Allegade.class));
	}

	@Test
	public void testNormalTurn() {
		//Take an normal turn.
		random.add(5, 3, 2);
		int offset = p1.getOffsetPosition(10);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);
	}

	@Test
	public void testMrMonopolyTurn() {
		//Take a Mr. Monopoly turn.
		random.add(2, 3, 4);
		int offset = p1.getOffsetPosition(5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(offset);
	}

	@Test
	public void testYahtzeeFromJail() {
		//Roll a yahtzee when in jail.
		p1.arrest();
		random.add(2, 2, 5);
		gui.addActions(true);
		p1.rollAndMove();
		assertThat(p1.isJailed()).isFalse();
	}

	@Test
	public void testTripleRoll() {
		//Take a triple turn
		random.add(2,2,2);
		gui.addActions(game.getBoard().getField(Hvidovrevej.class), true);
		p1.rollAndMove();
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(Hvidovrevej.class));
	}

	@Test
	public void testTakeExtraTurnOnDoubleRoll() {
		random.add(2, 2, 1);
		gui.addActions(true, game.getBoard().getField(HelsingoerHelsingborg.class));
		p1.rollAndMove();
		assertThat(game.getTurns().pop()).isInstanceOf(RegularTurn.class);
	}

	/**
	 * @see Player#isBailable()
	 */
	@Test
	public void testIsBailable(){
		//Not in jail, has money
		assertThat(p1.isBailable()).isFalse();

		//In jail, has money.
		p1.arrest();
		assertThat(p1.isBailable()).isTrue();

		//In jail, no money.
		p1.getAccount().setBalance(0);
		assertThat(p1.isBailable()).isFalse();

		//Not in jail, no money.
		p1.release();
		assertThat(p1.isBailable()).isFalse();
	}

	/**
	 * @see Player#tryBail()
	 */
	@Test
	public void testTryBail(){
		//Not in jail, has money.
		assertThat(p1.tryBail()).isFalse();

		//In jail, has money.
		p1.arrest();
		assertThat(p1.tryBail()).isTrue();
		assertThat(p1.getAccount().getBalance()).isEqualTo(9000);

		//In jail, no money.
		p1.getAccount().setBalance(0);
		assertThat(p1.isBailable()).isFalse();
	}


}