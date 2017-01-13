package Board.Fields.Properties.Ships;

import Board.Fields.Properties.Property;
import Buildings.Hotel;
import Buildings.House;
import Game.Game;

public abstract class Ship extends Property {

    public Ship(Game game, String name) {
        super(game, name, "", 4000);
    }

    @Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}



