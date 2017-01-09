package GUI;

import Board.Fields.Field;
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
    public int selectInteger(Player player, String message) {
        return 0;
    }

    @Override
    public Field chooseField(Player player, String message, Field... fields) {
        return null;
    }

    @Override
    public boolean acceptAction(Player player, String message) {
        return false;
    }

}
