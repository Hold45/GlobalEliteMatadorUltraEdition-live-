package GUI;

import Board.Fields.Field;
import Cards.Tradable;
import Game.Actions.Action;
import Owners.Player;

import java.util.Stack;

public class SmartGUI implements MonopolyGUI {
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
	public int selectInteger(Player player, String message) {
		return (int) actionsStack.pop();
	}

	@Override
	public Field chooseField(Player player, String message, Field... fields) {
		return (Field) actionsStack.pop();
	}

	@Override
	public boolean acceptAction(Player player, String message) {
		return (boolean) actionsStack.pop();
	}

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		return (boolean) actionsStack.pop();
	}
}