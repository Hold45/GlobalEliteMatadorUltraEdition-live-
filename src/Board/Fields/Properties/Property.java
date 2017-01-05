package Board.Fields.Properties;

import Board.Fields.Field;
import Board.Fields.Properties.Deeds.Deed;
import Buildings.Building;
import Game.Game;

import java.util.ArrayList;

public abstract class Property extends Field {

	protected Deed deed;
	protected ArrayList<Building> buildings;
	protected boolean pawned;

	public Property(Game game, String name, String description, int price) {
		super(game, name, description);
		this.deed = new Deed(this, price, game.getBank());
		this.buildings = new ArrayList<>();
		this.pawned = false;
	}

	public abstract int getRent();

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	public boolean isPawned() {
		return this.pawned;
	}

	public Deed getDeed() {
		return this.deed;
	}
}

