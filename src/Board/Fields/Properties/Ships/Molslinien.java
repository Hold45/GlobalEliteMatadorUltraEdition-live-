package Board.Fields.Properties.Ships;

import Board.Fields.Properties.Property;
import Game.Game;

public class Molslinien extends Property {
	
	public Molslinien(Game game, String name, String description){
		super(game, "SHIPMOLSLINIEN", description, 4000);
		}

	@Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}
