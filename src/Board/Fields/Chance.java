package Board.Fields;

import Game.Game;
import Owners.Player;

import java.awt.*;


public class Chance extends Field {
	 
	public Chance(Game game) {
        super(game, "ChanceName", "ChanceDesc", Color.black, Color.white);
        
    }
	public void onLand(Player player){
		super.onLand(player);
		this.game.getCardPile().drawCard(player);
	}

	
}