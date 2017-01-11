package GUI;

import Board.Fields.Field;
import Cards.Tradable;
import Game.Actions.Action;
import Game.Game;
import Owners.Player;
import desktop_fields.Empty;
import desktop_fields.Street;
import desktop_resources.*;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 */
public class RonnyGUI implements MonopolyGUI {
	private Game game;
	private ArrayList<desktop_fields.Field> fields;

	public static void main(String... args){
		RonnyGUI gui = new RonnyGUI();
		gui.game = new Game(gui);

		gui.game.addPlayers(
				new Player(gui.game),
				new Player(gui.game)
		);

		gui.createBoard(gui.game);

	}

	public void createBoard(Game game) {
		Field[] fields = game.getBoard().getFields();

		Stream.of(fields).forEach(this::addField);

		for (int i = fields.length; i < 40; i++) {
			this.fields.add(new Empty.Builder().build());
		}

		desktop_fields.Field[] guiFields = new desktop_fields.Field[40];
		guiFields = this.fields.toArray(guiFields);
		desktop_resources.GUI.create(guiFields);
	}

	public void addField(Field field){
		desktop_fields.Field guiField = new Street.Builder().build();
		guiField.setTitle(field.getName());
		guiField.setDescription(field.getDescription());
		this.fields.add(guiField);
	}


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

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		return false;
	}
}
