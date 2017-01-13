package Board.Fields.Properties.Plots.RedPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

abstract class RedPlot extends Plot {
	
	RedPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name,Color.red, price, rentScheme);
	}

	RedPlot(Game game, String name){
		super(game, name,Color.red, 4400, new int[]{350, 1800, 5000, 14000, 17500, 21000});
	}

}
