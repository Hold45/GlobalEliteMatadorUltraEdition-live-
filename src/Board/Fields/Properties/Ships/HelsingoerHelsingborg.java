package Board.Fields.Properties.Ships;

import Board.Fields.Properties.Property;
import Game.Game;

public class HelsingoerHelsingborg extends Property {
	
	public HelsingoerHelsingborg(Game game, String name, String description){
		super(game, "SHIPHELSING�R", description, 4000);
	}
	
	@Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}

