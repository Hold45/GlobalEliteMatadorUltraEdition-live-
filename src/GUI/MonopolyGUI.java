package GUI;

import Board.Fields.Field;
import Cards.Tradable;
import Finance.Account;
import Game.Actions.Action;
import Owners.Player;

public interface MonopolyGUI {

	Action chooseAction(Player player, String message, Action... options);

	Tradable chooseTradable(Player player, String message, Tradable... tradables);

	Player choosePlayer(Player player, String message, Player... players);

	int selectInteger(Player player, String message);

	Field chooseField(Player player, String message, Field... fields);

	boolean acceptAction(Player player, String message);

	boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price);

}