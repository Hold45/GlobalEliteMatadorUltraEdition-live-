package Board.Fields.Properties.Ships;

import Board.Fields.Properties.Property;
import Game.Game;

public class RoedbyPuttgarden extends Property {
	
	public RoedbyPuttgarden(Game game, String name, String description){
		super(game, "SHIPROEDBY", "description", 4000);
		}
	
	@Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}
