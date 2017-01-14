package Board.Fields.Properties.Brewery;

import Board.Fields.Properties.Property;
import Dice.Die;
import Game.Game;

import java.awt.*;


public abstract class Brewery extends Property {

    public Brewery(Game game, String name, Color color) {
        super(game, name, "BreweryDesc", color, 1500);
    }

    @Override
    public int getRent() {
       // return (int) Math.pow(2, this.getOwnedFriends().count()-1);

        if (getOwnedFriends().count() == 1)
        {
            return Math.abs(100 * getGame().getCup().getSum());
        } else {
            return Math.abs(200 * getGame().getCup().getSum());
        }

    }
}