package Board.Fields.Properties.Plots.GreenPlots;

import java.awt.Color;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

/**
 *
 */
abstract class GreenPlot extends Plot {

	GreenPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, Color.green, price, rentScheme);
	}

	GreenPlot(Game game, String name){
		super(game, name, Color.green, 2800, new int[]{200, 1000, 3000, 9000, 12500, 15000});
	}

}
