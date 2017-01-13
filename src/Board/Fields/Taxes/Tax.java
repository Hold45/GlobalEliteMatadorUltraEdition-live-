package Board.Fields.Taxes;
import Board.Fields.Field;
import Game.Game;
import Owners.Player;

import java.awt.*;

public abstract class Tax extends Field {

	public Tax(Game game, String name, String description) {
		super(game, name, description, Color.darkGray, Color.black);
	}

	@Override
	public void onLand(Player player) {
		super.onLand(player);
		player.getAccount().transferTo(player.getGame().getBank().getAccount(), this.getTax(player));
	}

	public abstract int getTax(Player player);
}
