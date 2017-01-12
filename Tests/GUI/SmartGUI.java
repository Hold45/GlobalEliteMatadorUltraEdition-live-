package GUI;

import Board.Board;
import Board.Fields.Field;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Actions.Action;
import Game.Game;
import Owners.Player;

import java.util.Stack;

public class SmartGUI implements MonopolyGUI {
	public Game game;
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
	public Action chooseAction(Player player, String message, Action... options) {
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



	@Override
	public int getIntegerFromPlayer(Player player, String message) {
		return (int) actionsStack.pop();
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price) {
		return (boolean) actionsStack.pop();
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message) {
		return (boolean) actionsStack.pop();
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
	public String getSelectionFromPlayer(Player player, String message, String... actions) {
		return (String) actionsStack.pop();
	}

	@Override
	public Game getGame() {
		return this.game;
	}
}