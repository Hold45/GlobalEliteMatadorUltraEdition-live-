package Board.Fields.Properties.Plots.OrangePlots;

import java.awt.Color;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

/**
 *
 */
abstract class OrangePlot extends Plot {
	
	OrangePlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, Color.orange, price, rentScheme);
	}

	OrangePlot(Game game, String name){
		super(game, name,Color.orange, 2000, new int[]{100, 600, 1800, 5400, 8000, 11000});
	}

}
