package GUI;

import Board.Board;
import Board.Fields.Field;
import Board.Fields.Properties.Property;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Game;
import Owners.Player;
import desktop_codebehind.Car;
import desktop_fields.Empty;
import desktop_fields.Street;
import desktop_resources.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.stream.Stream;

/**
 *
 */
public class RonnyGUI implements MonopolyGUI {
	private Game game;
	private ArrayList<desktop_fields.Field> fields;
	private Stack<Color> colors = new Stack<>();
	private ResourceBundle language;

	public RonnyGUI() {
		this.fields = new ArrayList<>();
		this.game = new Game(this);

		colors.push(Color.BLACK);
		colors.push(Color.GREEN);
		colors.push(Color.PINK);
		colors.push(Color.CYAN);
		colors.push(Color.MAGENTA);
		colors.push(Color.LIGHT_GRAY);
		
		this.language = ResourceBundle.getBundle("LabelsBundle", Locale.getDefault());
	}

	@Override
	public void playerLoose(Player player) {
		this.setPosition(player);
		this.setBalance(player);
		desktop_resources.GUI.removeCar(player.getPosition()+1, player.getName());
	}

	@Override
	public Game getGame() {
		return this.game;
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

		gui.start();
	}




	@Override
	public void createBoard(Field... fields) {
		Stream.of(fields).forEach(this::addField);


		for (int i = fields.length; i < 40; i++)
			this.fields.add(new Empty.Builder().build());

		desktop_resources.GUI.create(this.fields.toArray(new desktop_fields.Field[40]));
	}

	@Override
	public String getSelectionFromPlayer(Player player, String message, String... actions) {
		return GUI.getUserSelection(player.getName()+": "+message, actions);
	}

	@Override
	public void addPlayer(Player player){
		desktop_resources.GUI.addPlayer(player.getName(), player.getAccount().getBalance(), new Car.Builder().primaryColor(this.colors.pop()).typeUfo().build());
	}


	private void addField(Field field){
		//Color c = new Color(255, 0, 0);
		desktop_fields.Field guiField = new Street.Builder().setBgColor(field.getColor()).setFgColor(field.getTcol()).build();
		guiField.setTitle(this.language.getString(field.getName()));
		guiField.setDescription(this.language.getString(field.getDescription()));
		this.fields.add(guiField);		
	}

	@Override
	public void setDice(MonopolyCup cup){
		GUI.setDice(cup.getValues()[0], cup.getValues()[1]);
	}

	@Override
	public void setPosition(Player player){
		desktop_resources.GUI.removeAllCars(player.getName());
		desktop_resources.GUI.setCar(player.getPosition()+1, player.getName());
	}

	@Override
	public void setBalance(Player player){
		desktop_resources.GUI.setBalance(player.getName(), player.getAccount().getBalance());
	}

	@Override
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

	@Override
	public int getIntegerFromPlayer(Player player, String message) {
		return GUI.getUserInteger(player.getName()+": "+message);
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message) {
		return GUI.getUserLeftButtonPressed(player.getName()+": "+message, "Accept", "Decline");
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price) {
		return getBooleanFromPlayer(player, message);
	}
}
