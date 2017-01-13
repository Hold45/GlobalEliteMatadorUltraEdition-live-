package Board.Fields;

import Game.Game;
import Owners.Player;


public class ChanceField extends Field {
	
   
	public ChanceField(Game game, String name, String description) {
        super(game, "ChanceField", "description)");
        
    }
	public void onLand(Player player){
		super.onLand(player);
		this.game.getCardPile().drawCard(player);
		
	}

	
}