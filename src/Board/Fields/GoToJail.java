package Board.Fields;

import Game.Game;
import Owners.Player;

import java.awt.*;


public class GoToJail extends Field {
	
   
	public GoToJail(Game game) {
        super(game, "GoToJail", "GoToJailDescription",Color.black, Color.white);
    }
	
	public void onLand(Player player){
		super.onLand(player);
		player.arrest();	
	}

}