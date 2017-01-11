package GUI;

import Board.Fields.Field;
import Cards.Tradable;
import Game.Actions.Action;
import Owners.Player;

import java.util.Random;

/**
 *
 */
public class DummyGUI implements MonopolyGUI {

	@Override
	public Action chooseAction(Player player, String message, Action... options) {
		return options[new Random().nextInt(options.length)];
	}

	@Override
	public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
		return tradables[new Random().nextInt(tradables.length)];
	}

	@Override
	public Player choosePlayer(Player player, String message, Player... players) {
		return players[new Random().nextInt(players.length)];
	}

	@Override
	public int selectInteger(Player player, String message) {
		return 0;
	}

	@Override
	public Field chooseField(Player player, String message, Field... fields) {
		return fields[new Random().nextInt(fields.length)];
	}

	@Override
	public boolean acceptAction(Player player, String message) {
		return new Random().nextBoolean();
	}

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		return new Random().nextBoolean();
	}
}
