package Board.Fields.Ownables;

import Board.Fields.Field;
import Board.Fields.Ownables.Deeds.Deed;
import Buildings.Building;
import Game.Game;

import java.util.ArrayList;

public abstract class Ownable extends Field {

	protected Deed deed;
	protected ArrayList<Building> buildings;

	public Ownable(Game game, String name, String description, int price) {
		super(game, name, description);
		this.deed = new Deed(this, price, game.getBank());
		this.buildings = new ArrayList<>();
	}

	public abstract int getRent();

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}
}

