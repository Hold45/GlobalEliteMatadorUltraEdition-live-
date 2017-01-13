package Board.Fields.Properties.Ships;

import java.awt.Color;

import Board.Fields.Properties.Property;
import Game.Game;

public abstract class Ship extends Property {

    public Ship(Game game, String name, Color color) {
        super(game, name, "", color, 4000);
    }

    @Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}



