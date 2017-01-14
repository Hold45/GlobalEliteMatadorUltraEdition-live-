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
      
            return getGame().getCup().getSum()*100*((int)this.getOwnedFriends().count());     

    }
}