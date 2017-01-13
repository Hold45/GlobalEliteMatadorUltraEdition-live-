package Board.Fields.Properties.Plots.GreyPlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

abstract class GreyPlot extends Plot {

	GreyPlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name,Color.gray, price, rentScheme);
	}

	GreyPlot(Game game, String name){
		super(game, name, Color.gray, 3600, new int[]{300, 1400, 4000, 11000, 15000, 19000});
	}


}