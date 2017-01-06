package Board.Fields.Properties.Plots.RedPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class RedPlot extends Plot {
	
	RedPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	RedPlot(Game game, String name){
		super(game, name, 4400, new int[]{350, 1800, 5000, 14000, 17500, 21000});
	}

}
