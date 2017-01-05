package Board.Fields.Properties.Plots.YellowPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

/**
 *
 */
public abstract class YellowPlot extends Plot {

	public YellowPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	public YellowPlot(Game game, String name){
		super(game, name, 6000, new int[]{550, 2600, 7800, 1800, 22000, 25000});
	}


}
