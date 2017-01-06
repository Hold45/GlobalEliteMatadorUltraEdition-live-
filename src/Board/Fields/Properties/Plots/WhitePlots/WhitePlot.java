package Board.Fields.Properties.Plots.WhitePlots;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class WhitePlot extends Plot {

	WhitePlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}

	WhitePlot(Game game, String name){
		super(game, name, 5200, new int[]{450, 2200, 6600, 16000, 19500, 23000});
	}

	
}
