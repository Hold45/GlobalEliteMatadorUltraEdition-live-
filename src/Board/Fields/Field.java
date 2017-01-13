package Board.Fields;

import Game.Game;
import Owners.Player;

import java.awt.*;

public abstract class Field {

	protected Game game;
	private String name;
	private String description;
	private Color color;
	private Color tcol;

	public Field(Game game, String name, String description, Color color, Color tcol){
		this.game = game;
		this.name = name;
		this.description = description;
		this.color = color;
		this.tcol = tcol;
	}

	public void onLand(Player player){

	}

    public void onMoveOver(Player player){

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

	public Color getColor() {
		return this.color;
	}

	public Color getTcol() {
		return tcol;
	}


}
