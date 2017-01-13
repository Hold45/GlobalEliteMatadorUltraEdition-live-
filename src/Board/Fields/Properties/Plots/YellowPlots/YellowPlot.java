package Board.Fields.Properties.Plots.YellowPlots;

import java.awt.Color;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class YellowPlot extends Plot {

	YellowPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name,Color.yellow, price, rentScheme);
	}

	YellowPlot(Game game, String name){
		super(game, name,Color.yellow, 6000, new int[]{550, 2600, 7800, 18000, 22000, 25000});
	}


}
