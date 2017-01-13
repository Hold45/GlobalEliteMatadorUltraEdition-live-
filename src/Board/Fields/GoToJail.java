package Board.Fields;

import Game.Game;
import Owners.Player;


public class GoToJail extends Field {
	
   
	public GoToJail(Game game) {
        super(game, "GoToJail", "GoToJailDescription");
    }
	
	public void onLand(Player player){
		super.onLand(player);
		player.arrest();	
	}

}