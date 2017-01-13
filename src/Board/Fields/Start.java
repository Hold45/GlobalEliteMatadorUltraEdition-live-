package Board.Fields;

import java.awt.Color;

import Game.Game;
import Owners.Player;

import java.util.ArrayList;


public class Start extends Field {
	private ArrayList<Player> hasPassed;

    public Start(Game game) {
<<<<<<< HEAD
        super(game, "FieldStart", "description", Color.red, Color.black);
=======
        super(game, "FieldStart", "description");
        hasPassed = new ArrayList<>();
>>>>>>> branch 'master' of https://github.com/Hold45/GlobalEliteMatadorUltraEdition-live-.git
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
