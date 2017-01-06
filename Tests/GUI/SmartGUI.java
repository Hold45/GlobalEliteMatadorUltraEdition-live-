package GUI;

import Cards.Tradable;
import Finance.Account;
import Game.Actions.Action;
import Owners.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class SmartGUI implements GUI{
	private Stack<Object> actionsStack;

	public SmartGUI() {
		actionsStack = new Stack<>();
	}

	public void addActions(Object... actions){
		for (Object action : actions) {
			actionsStack.push(action);
		}
	}

	@Override
	public int getField(int[] options) {
		return (int) actionsStack.pop();
	}

	@Override
	public Action chooseAction(Player player, Action... options) {
		return (Action) actionsStack.pop();
	}

	@Override
	public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
		return (Tradable) actionsStack.pop();
	}

	@Override
	public Player choosePlayer(Player player, String message, Player... players) {
		return (Player) actionsStack.pop();
	}

	@Override
	public int selectInteger(Player player, String message, Account account) {
		return (int) actionsStack.pop();
	}
}