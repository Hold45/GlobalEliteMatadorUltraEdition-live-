package Board.Fields.Ownables.Plots.GreyPlots;

import Board.Fields.Ownables.Plots.Plot;
import Game.Game;

/**
 *
 */
public abstract class GreyPlot extends Plot {

	public GreyPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	public GreyPlot(Game game, String name){
		super(game, name, 6000, new int[]{550, 2600, 7800, 1800, 22000, 25000});
	}


}