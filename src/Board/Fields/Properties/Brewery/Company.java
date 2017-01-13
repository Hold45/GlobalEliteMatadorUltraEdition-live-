package Board.Fields.Properties.Brewery;

import Board.Fields.Properties.Property;
import Game.Game;


public abstract class Company extends Property {

    public Company(Game game, String name) {
        super(game, name, "", 3000);
    }

    @Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}