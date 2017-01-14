package GUI;

import Board.Board;
import Board.Fields.Field;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Actions.Action;
import Game.Game;
import Owners.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SmartGUI implements MonopolyGUI {
	public Game game;
	private Queue<Object> actionsStack;

	public SmartGUI() {
		actionsStack = new LinkedList<>();
	}

	public void addActions(Object... actions){
		for (Object action : actions) {
			actionsStack.add(action);
		}
	}

	@Override
	public Action chooseAction(Player player, String message, Action... options) {
		return (Action) actionsStack.poll();
	}

	@Override
	public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
		return (Tradable) actionsStack.poll();
	}

	@Override
	public Player choosePlayer(Player player, String message, Player... players) {
		return (Player) actionsStack.poll();
	}

	@Override
	public int selectInteger(Player player, String message) {
		return (int) actionsStack.poll();
	}

	@Override
	public Field chooseField(Player player, String message, Field... fields) {
		return (Field) actionsStack.poll();
	}

	@Override
	public boolean acceptAction(Player player, String message) {
		return (boolean) actionsStack.poll();
	}

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		return (boolean) actionsStack.poll();
	}

	@Override
	public String getStringFromPlayer(Player player, String message) {
		return (String) actionsStack.poll();
	}

	@Override
	public String getString(String mesasge) {
		return (String) actionsStack.poll();
	}

	@Override
	public int getIntegerFromPlayer(Player player, String message) {
		return (int) actionsStack.poll();
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price) {
		return (boolean) actionsStack.poll();
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message) {
		return (boolean) actionsStack.poll();
	}

	@Override
	public void addMessage(Player player, String message) {

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
	public void update() {

	}

	@Override
	public String getSelectionFromPlayer(Player player, String message, String... actions) {
		return (String) actionsStack.poll();
	}

	@Override
	public Game getGame() {
		return this.game;
	}
}