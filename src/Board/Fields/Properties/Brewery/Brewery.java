package Board.Fields.Properties.Brewery;

import java.awt.Color;

import Board.Fields.Properties.Property;
import Game.Game;


public abstract class Brewery extends Property {

    public Brewery(Game game, String name, Color color) {
        super(game, name, "", color, 3000);
    }

    @Override
    public int getRent() {
        return (int) Math.pow(2, this.getOwnedFriends().count()-1);
    }
}