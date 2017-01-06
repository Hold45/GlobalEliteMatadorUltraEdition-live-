package GUI;

import Cards.Tradable;
import Finance.Account;
import Game.Actions.Action;
import Owners.Player;

public class LarmanGUI implements GUI {
    @Override
    public int getField(int[] options) {
        return 0;
    }

    @Override
    public Action chooseAction(Player player, Action... options) {
        return null;
    }

    @Override
    public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
        return null;
    }

    @Override
    public Player choosePlayer(Player player, String message, Player... players) {
        return null;
    }

    @Override
    public int selectInteger(Player player, String message, Account account) {
        return 0;
    }
}
