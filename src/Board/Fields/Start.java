package Board.Fields;

import Game.Game;
import Owners.Player;
import java.awt.*;
import java.util.ArrayList;


public class Start extends Field {
	private ArrayList<Player> hasPassed;

	public Start(Game game) {
		super(game, "FieldStart", "StartDescription", Color.red, Color.black);
		hasPassed = new ArrayList<>();

	}

	@Override
	public void onMoveOver(Player player) {
		super.onMoveOver(player);
		if(this.hasPassed.contains(player))
			this.game.getBank().getAccount().transferTo(player.getAccount(), 4000);
		else
			this.hasPassed.add(player);
	}
}
