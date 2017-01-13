package Board.Fields;

import java.awt.Color;
import Game.Game;
import Owners.Player;


public class Chance extends Field {
	 
	public Chance(Game game) {
        super(game, "ChanceName", "ChanceDesc", Color.black, Color.white);
        
    }
	public void onLand(Player player){
		super.onLand(player);
		this.game.getCardPile().drawCard(player);
	}

	
}