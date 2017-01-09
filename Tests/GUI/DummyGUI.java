package GUI;

import Board.Fields.Field;
import Cards.Tradable;
import Game.Actions.Action;
import Owners.Player;

/**
 *
 */
public class DummyGUI implements GUI {
	@Override
	public int getField(int[] options) {
		return options[0];
	}

	@Override
	public Action chooseAction(Player player, Action... options) {
		return options[0];
	}

	@Override
	public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
		return tradables[0];
	}

	@Override
	public Player choosePlayer(Player player, String message, Player... players) {
		return players[0];
	}

	@Override
	public int selectInteger(Player player, String message) {
		return 1000;
	}

	@Override
	public Field chooseField(Player player, String message, Field... fields) {
		return fields[0];
	}

	@Override
	public boolean acceptAction(Player player, String message) {
		return true;
	}

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		return true;
	}
}
