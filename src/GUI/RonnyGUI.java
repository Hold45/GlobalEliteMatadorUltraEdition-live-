package GUI;

import Board.Board;
import Board.Fields.Field;
import Board.Fields.Properties.Property;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Actions.Action;
import Game.Game;
import Owners.Player;
import desktop_codebehind.Car;
import desktop_fields.Empty;
import desktop_fields.Street;
import desktop_resources.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

/**
 *
 */
public class RonnyGUI implements MonopolyGUI {
	private Game game;
	private ArrayList<desktop_fields.Field> fields;
	private Stack<Color> colors = new Stack<>();

	public RonnyGUI() {
		this.fields = new ArrayList<>();
		this.game = new Game(this);

		colors.push(Color.BLACK);
		colors.push(Color.GREEN);
		colors.push(Color.PINK);
		colors.push(Color.CYAN);
		colors.push(Color.MAGENTA);
		colors.push(Color.LIGHT_GRAY);
	}

	public static void main(String... args){
		RonnyGUI gui = new RonnyGUI();
		Player p1 = new Player(gui.game);
		Player p2 = new Player(gui.game);

		p1.setName("CE");
		p2.setName("Oliver");
		gui.game.addPlayers(
				p1,
				p2
		);

		gui.createBoard();

		gui.game.start();

		GUI.getUserInteger("test");

	}

	private void addPlayers() {
		game.getPlayers().forEach(this::addPlayer);
	}

	private void addPlayer(Player player){
		desktop_resources.GUI.addPlayer(player.getName(), player.getAccount().getBalance(), new Car.Builder().primaryColor(this.colors.pop()).typeUfo().build());
	}

	private void createBoard() {
		Field[] fields = this.game.getBoard().getFields();

		Stream.of(fields).forEach(this::addField);

		for (int i = fields.length; i < 40; i++)
			this.fields.add(new Empty.Builder().build());

		desktop_resources.GUI.create(this.fields.toArray(new desktop_fields.Field[40]));
		addPlayers();
	}

	private void addField(Field field){
		desktop_fields.Field guiField = new Street.Builder().build();
		guiField.setTitle(field.getName());
		guiField.setDescription(field.getDescription());
		this.fields.add(guiField);
	}

	private void setDice(MonopolyCup cup){
		GUI.setDice(cup.getValues()[0], cup.getValues()[1]);
	}

	private void setPosition(Player player){
		desktop_resources.GUI.removeAllCars(player.getName());
		desktop_resources.GUI.setCar(player.getPosition()+1, player.getName());
	}

	private void setBalance(Player player){
		desktop_resources.GUI.setBalance(player.getName(), player.getAccount().getBalance());
	}

	public void setOwners(Board board){
		for (int i = 0; i < board.getFields().length; i++) {
			if(board.getFields()[i] instanceof Property){
				Property property = (Property) board.getFields()[i];
				desktop_resources.GUI.removeOwner(i+1);
				if(property.getDeed().isPlayerOwned()){
					desktop_resources.GUI.setOwner(i+1,property.getDeed().getOwner().toString());
				}
			}
		}
	}

	private void update(){
		this.setDice(game.getCup());

		for (Player player: game.getPlayers()) {
			this.setPosition(player);
			this.setBalance(player);
		}
		for (Player player: game.getLosers()){
			this.setPosition(player);
			this.setBalance(player);
			desktop_resources.GUI.removeCar(player.getPosition()+1, player.getName());
		}

		this.setOwners(game.getBoard());
	}


	@Override
	public Action chooseAction(Player player, String message, Action... options) {
		return (Action) chooseOption(player, message, options);
	}

	private Object chooseOption(Player player, String message, Object[] options) {
		this.update();
		String[] actionsAsString = Arrays.stream(options).map(Object::toString).toArray(String[]::new);
		String selected = GUI.getUserSelection(player.getName()+": "+message, actionsAsString);
		int index = Arrays.asList(actionsAsString).indexOf(selected);
		return options[index];
	}

	@Override
	public Tradable chooseTradable(Player player, String message, Tradable... tradables) {
		return (Tradable) chooseOption(player, message, tradables);
	}

	@Override
	public Player choosePlayer(Player player, String message, Player... players) {
		return (Player) chooseOption(player, message, players);
	}

	@Override
	public int selectInteger(Player player, String message) {
		this.update();
		return GUI.getUserInteger(player.getName()+": "+message);
	}

	@Override
	public Field chooseField(Player player, String message, Field... fields) {
		return (Field) chooseOption(player, message, fields);
	}

	@Override
	public boolean acceptAction(Player player, String message) {
		this.update();
		return GUI.getUserLeftButtonPressed(player.getName()+": "+message, "Accept", "Decline");
	}

	@Override
	public boolean acceptBuyProperty(Player player, String message, Tradable tradable, int price) {
		this.update();
		return GUI.getUserLeftButtonPressed(player.getName()+": "+message, "Accept", "Decline");
	}
}
