package Board.Fields;

import Game.Game;
import Owners.Player;


public class Chance extends Field {
	
   
	public Chance(Game game) {
        super(game, "Chance", "description)");
        
    }
	public void onLand(Player player){
		super.onLand(player);
		this.game.getCardPile().drawCard(player);
		
	}

	
}