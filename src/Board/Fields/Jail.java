package Board.Fields;

import java.awt.Color;

import Game.Game;
import Owners.Player;


public class Jail extends Field {
	
   
	public Jail (Game game) {
        super(game, "JailName", "JailDesc", Color.black, Color.white);
    }
	

}