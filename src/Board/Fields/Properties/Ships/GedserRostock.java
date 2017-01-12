package Board.Fields.Properties.Ships;

import Board.Fields.Properties.Property;
import Game.Game;

public class GedserRostock extends Property {
	
	public GedserRostock(Game game, String name, String description){
		super(game, "SHIPGEDSER", description, 4000);
		}

	@Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}
