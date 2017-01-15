package Game;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Property;
import Board.Board;
import Cards.CardPile;
import Dice.MonopolyCup;
import GUI.SmartGUI;
import Owners.Bank;
import Owners.Player;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

/**
 *
 */
public abstract class SmartTemplateTest {
	protected Game game;
	protected Player p1;
	protected Player p2;
	protected SmartGUI gui;
	protected MonopolyCup cup;
	protected SmartRandom random;
	protected Bank bank;
	protected CardPile cardPile;
	protected Board board;
	protected Deed hvid;
	protected Deed roed;

	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("java.awt.headless", "true");
		gui = new SmartGUI();
		random = new SmartRandom();
		for (int i = 1; i < new CardPile(new Game(gui), new Random()).getCards().size(); i++) {
			random.add(1);
		}

		game = new Game(gui, random);
		gui.game = game;
		p1 = new Player(game, "Player 1");
		p1.getAccount().setBalance(10000);
		p2 = new Player(game, "Player 2");
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
	public void baseTearDown() throws Exception {
		game = null;
		gui = null;
		p1 = null;
		p2 = null;
		cup = null;
		random = null;
		bank = null;
		cardPile = null;
		board = null;
		hvid = null;
		roed = null;
	}
}
