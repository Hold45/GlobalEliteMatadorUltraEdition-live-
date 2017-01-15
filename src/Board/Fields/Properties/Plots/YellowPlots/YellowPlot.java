package Board.Fields.Properties.Plots.YellowPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

abstract class YellowPlot extends Plot {

	YellowPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name,Color.yellow, price, 4000, rentScheme);
	}

	YellowPlot(Game game, String name){
		super(game, name,Color.yellow, 6000, 4000, new int[]{550, 2600, 7800, 18000, 22000, 25000});
	}


}
