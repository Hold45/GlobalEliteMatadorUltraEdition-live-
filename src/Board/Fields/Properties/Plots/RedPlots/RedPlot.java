package Board.Fields.Properties.Plots.RedPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

public abstract class RedPlot extends Plot {
	
	public RedPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	public RedPlot(Game game, String name){
		super(game, name, 6000, new int[]{550, 2600, 7800, 1800, 22000, 25000});
	}

}
