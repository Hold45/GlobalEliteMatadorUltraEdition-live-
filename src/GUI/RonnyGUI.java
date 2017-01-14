package GUI;

import Board.Board;
import Board.Fields.Field;
import Board.Fields.Properties.Property;
import Buildings.Hotel;
import Buildings.House;
import Cards.Tradable;
import Dice.MonopolyCup;
import Game.Game;
import Owners.Player;
import desktop_codebehind.Car;
import desktop_fields.Empty;
import desktop_fields.Street;
import desktop_resources.GUI;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class RonnyGUI implements MonopolyGUI {
	private Game game;
	private ArrayList<desktop_fields.Field> fields;
	private Stack<Color> colors = new Stack<>();
	private ResourceBundle language;
	private String message;

	public RonnyGUI() {
		this.fields = new ArrayList<>();
		colors.push(Color.GREEN);
		colors.push(Color.PINK);
		colors.push(Color.CYAN);
		colors.push(Color.MAGENTA);
		colors.push(Color.LIGHT_GRAY);
		colors.push(Color.BLACK);
		this.language = ResourceBundle.getBundle("LabelsBundle", Locale.getDefault());
		this.message = "";
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

	@Override
	public void update(){
		this.setDice(this.getGame().getCup());

		for (Player player : this.getGame().getPlayers()) {
			this.setPosition(player);
			this.setBalance(player);
		}
		for (Player player : this.getGame().getPlayers()){
			this.playerLoose(player);
		}

		for (
			Field field :
			Arrays.stream(this.getGame().getBoard().getFields())
				.filter(field -> field instanceof Property)
				.collect(Collectors.toCollection(ArrayList::new))
		){
			this.setBuiildings((Property) field);
		}

		this.setOwners(this.getGame().getBoard());

		if (!this.message.isEmpty())
			desktop_resources.GUI.showMessage(this.popMessage());
	}

	private void setBuiildings(Property property){
		int index = this.getGame().getBoard().getIndex(property)+1;
		desktop_resources.GUI.setHouses(
			index,
			(int) property.getBuildings().stream()
				.filter(building -> building instanceof House)
					.count()
		);
		if (
			property.getBuildings().stream()
				.anyMatch(building -> building instanceof Hotel)
		){
			desktop_resources.GUI.setHotel(index, true);
		}
	}

	public static void main(String... args){
		RonnyGUI gui = new RonnyGUI();
		gui.game = new Game(gui);
		gui.setup();
		ArrayList<String> names = gui.getPlayerNames();
		Player[] players = names.stream().map(name -> new Player(gui.game, name)).toArray(Player[]::new);
		gui.game.addPlayers(players);
		gui.createPlayers();
		gui.game.start();
	}

	@Override
	public void createBoard(Field... fields) {
		assert fields.length <= 40;
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
		desktop_resources.GUI.addPlayer(
			player.getName(),
			player.getAccount().getBalance(),
			new Car.Builder().primaryColor(this.colors.pop()).typeUfo().build()
		);
	}

	public ArrayList<String> getPlayerNames() {
		ArrayList<String> names =  new ArrayList<String>();
		int playerNum = desktop_resources.GUI.getUserInteger(this.language.getString("NUMPLAYER"), 2,6);
		while (names.size() < playerNum){
			String name = this.getString("CHOOSEPLAYERNAME");
			if (!name.isEmpty() && !names.contains(name))
				names.add(name);
		}
		return names;
	}

	private void addField(Field field){
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
	public String getStringFromPlayer(Player player, String message) {
		return desktop_resources.GUI.getUserString(player.getName()+": "+this.language.getString(message));
	}

	@Override
	public String getString(String message) {
		return desktop_resources.GUI.getUserString(this.language.getString(message));
	}

	@Override
	public int getIntegerFromPlayer(Player player, String message) {
		return GUI.getUserInteger(player.getName()+": "+this.language.getString(message));
	}

	@Override
	public int getIntegerFromPlayer(Player player, String message, int min, int max){
		return desktop_resources.GUI.getUserInteger(player.getName()+": "+this.language.getString(message));
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message) {
		return GUI.getUserLeftButtonPressed(player.getName()+": "+this.language.getString(message), "Accept", "Decline");
	}

	private String popMessage(){
		String message = this.message;
		this.message = "";
		return message;
	}

	@Override
	public void addMessage(Player player, String message) {
		this.message += "\n"+this.language.getString(message);
	}

	@Override
	public boolean getBooleanFromPlayer(Player player, String message, Tradable tradable, int price) {
		return GUI.getUserLeftButtonPressed(player.getName()+": "+this.language.getString(message)+"\n"+tradable.toString()+" for "+price, "Accept", "Decline");
	}
}
