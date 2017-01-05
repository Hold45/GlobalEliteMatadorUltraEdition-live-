package GUI;

import Cards.Tradable;
import Finance.Account;
import Game.Actions.Action;
import Owners.Player;

public interface GUI {
    int getField(int[] options);

	Action chooseAction(Player player, Action... options);

	Tradable chooseTradable(Player player, String message, Tradable... tradables);

	Player choosePlayer(Player player, String message, Player... players);

	int selectPayment(Player player, String message, Account account);

}
