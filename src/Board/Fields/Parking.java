package Board.Fields;

import java.awt.Color;
import Game.Game;
import Owners.Player;


public class Parking extends Field {
	
   
	public Parking(Game game) {
        super(game, "ParkName", "ParkDesc", Color.black, Color.white);
    }
}