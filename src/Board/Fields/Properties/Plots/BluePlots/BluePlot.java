package Board.Fields.Properties.Plots.BluePlots;


import java.awt.Color;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

public abstract class
BluePlot extends Plot {

	BluePlot(Game game, String name){
		super(game, name, Color.blue, 1200, new int[]{50, 250, 750, 2250, 4000, 6000});
	}

}
