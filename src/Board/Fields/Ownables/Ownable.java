package Board.Fields.Ownables;

import Board.Fields.Field;
import Board.Fields.Ownables.Deeds.Deed;
import Game.Game;

public abstract class Ownable extends Field {

	protected Deed deed;

	public Ownable(Game game, String name, String description, int price) {
		super(game, name, description);

		this.deed = new Deed(this, price, game.getBank());
	}
}

