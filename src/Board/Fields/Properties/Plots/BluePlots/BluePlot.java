package Board.Fields.Properties.Plots.BluePlots;


import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

public abstract class
BluePlot extends Plot {

	BluePlot(Game game, String name){
		super(game, name, Color.cyan, 1200, new int[]{50, 250, 750, 2250, 4000, 6000});
	}

}
