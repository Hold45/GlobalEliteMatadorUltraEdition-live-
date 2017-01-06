package Board.Fields.Properties.Plots.YellowPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class YellowPlot extends Plot {

	YellowPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	YellowPlot(Game game, String name){
		super(game, name, 6000, new int[]{550, 2600, 7800, 18000, 22000, 25000});
	}


}
