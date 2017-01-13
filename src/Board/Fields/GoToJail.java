package Board.Fields;

import java.awt.Color;

import Game.Game;
import Owners.Player;


public class GoToJail extends Field {
	
   
	public GoToJail(Game game) {
        super(game, "GoToJail", "GoToJailDesc",Color.black, Color.white);
    }
	
	public void onLand(Player player){
		super.onLand(player);
		player.arrest();	
	}

}