package GUI;

import Board.Board;
import Board.Fields.Field;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Game;
import Owners.Player;

import java.util.Random;

/**
 *
 */
public class DummyGUI implements MonopolyGUI {
	public Game game;

	@Override
	public String getSelectionFromPlayer(Player player, String message, String... actions) {
		return actions[new Random().nextInt(actions.length)];
	}

	@Override
	public int getIntegerFromPlayer(Player player, String message) {
		return 0;
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price) {
		return new Random().nextBoolean();
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message) {
		return new Random().nextBoolean();
	}

	@Override
	public void setDice(MonopolyCup cup) {

	}

	@Override
	public void setPosition(Player player) {

	}

	@Override
	public void setBalance(Player player) {

	}

	@Override
	public void setOwners(Board board) {

	}

	@Override
	public void playerLoose(Player player) {

	}

	@Override
	public void addPlayer(Player player) {

	}

	@Override
	public void createBoard(Field... fields) {

	}

	@Override
	public Game getGame() {
		return this.game;
	}
}
