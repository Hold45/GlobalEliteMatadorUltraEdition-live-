package GUI;

import Board.Board;
import Board.Fields.Field;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Actions.Action;
import Game.Game;
import Owners.Player;

import java.util.Arrays;

public interface MonopolyGUI {

	int getIntegerFromPlayer(Player player, String message);

	boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price);

	boolean getBooleanFromPlayer(Player player, String message);

	void setDice(MonopolyCup cup);

	void setPosition(Player player);

	void setBalance(Player player);

	void setOwners(Board board);

	void playerLoose(Player player);

	void addPlayer(Player player);

	void createBoard(Field... fields);

	String getSelectionFromPlayer(Player player, String message, String... actions);


	Game getGame();

	default void createPlayers(Player... players){
		Arrays.stream(players).forEach(this::addPlayer);
	}

	default void start(){
		createBoard(this.getGame().getBoard().getFields());
		createPlayers(this.getGame().getPlayers().toArray(new Player[this.getGame().getPlayers().size()]));
		this.getGame().start();
	}


	default Object chooseOption(Player player, String message, Object[] options) {
		this.update();
		if(options.length == 1)
			return options[0];

		String[] actionsAsString = Arrays.stream(options).map(Object::toString).toArray(String[]::new);
		String selected = getSelectionFromPlayer(player, message, actionsAsString);
		int index = Arrays.asList(actionsAsString).indexOf(selected);
		return options[index];
	}

	default void update(){
		this.setDice(this.getGame().getCup());

		for (Player player: this.getGame().getPlayers()) {
			this.setPosition(player);
			this.setBalance(player);
		}
		for (Player player: this.getGame().getLosers()){
			this.playerLoose(player);
		}

		this.setOwners(this.getGame().getBoard());
	}

	default Action chooseAction(Player player, String message, Action... options){
		return (Action) chooseOption(player, message, options);
	}

	default Tradable chooseTradable(Player player, String message, Tradable... tradables){
		return (Tradable) chooseOption(player, message, tradables);
	}

	default Player choosePlayer(Player player, String message, Player... players){
		return (Player) chooseOption(player, message, players);
	}

	default int selectInteger(Player player, String message) {
		this.update();
		return getIntegerFromPlayer(player, message);
	}


	default Field chooseField(Player player, String message, Field... fields){
		return (Field) chooseOption(player, message, fields);
	}

	default boolean acceptAction(Player player, String message){
		this.update();
		return getBooleanFromPlayer(player, message);
	}

	default boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price){
		this.update();
		return getBooleanFromPlayer(player, message, tradable, price);
	}

}
