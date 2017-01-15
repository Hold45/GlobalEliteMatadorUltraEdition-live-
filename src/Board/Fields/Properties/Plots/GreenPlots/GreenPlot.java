package Board.Fields.Properties.Plots.GreenPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

/**
 *
 */
abstract class GreenPlot extends Plot {

	GreenPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, Color.green, price, 2000, rentScheme);
	}

	GreenPlot(Game game, String name){
		super(game, name, Color.green, 2800, 2000, new int[]{200, 1000, 3000, 9000, 12500, 15000});
	}

}
