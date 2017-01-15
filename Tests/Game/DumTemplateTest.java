package Game;

import Board.Board;
import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Cards.CardPile;
import Dice.MonopolyCup;
import GUI.DummyGUI;
import Owners.Bank;
import Owners.Player;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

/**
 *
 */
public abstract class DumTemplateTest {
	protected Game game;
	protected Player p1;
	protected Player p2;
	protected DummyGUI gui;
	protected Bank bank;
	protected CardPile cardPile;
	protected Board board;
	protected MonopolyCup cup;
	protected Deed hvid;
	protected Deed roed;

	@Before
	public void baseSetUp() throws Exception{
		System.setProperty("java.awt.headless", "true");
		gui = new DummyGUI();
		game = new Game(gui);
		gui.game = game;
		p1 = new Player(game);
		p1.getAccount().setBalance(10000);
		p2 = new Player(game);
		p2.getAccount().setBalance(10000);
		game.addPlayers(p1, p2);
		cup = game.getCup();
		bank = game.getBank();
		cardPile = game.getCardPile();
		board = game.getBoard();
		hvid = ((Property) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		roed = ((Property) game.getBoard().getField(Roedovrevej.class)).getDeed();
	}

	@After
	public void BaseTearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
		cup = null;
		bank = null;
		cardPile = null;
		board = null;
		hvid = null;
		roed = null;
	}
}
