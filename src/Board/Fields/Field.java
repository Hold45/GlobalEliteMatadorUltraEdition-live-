package Board.Fields;

import Game.Game;
import Owners.Player;

public abstract class Field {

	protected Game game;
	private String name;
	private String description;

	public Field(Game game, String name, String description){
		this.game = game;
		this.name = name;
		this.description = description;
	}

	public void onLand(Player player){

	}

	public String getDescription() {
		return this.description;
	}

	public String getName() {
		return this.name;
	}

	public Game getGame() {
		return this.game;
	}
}
