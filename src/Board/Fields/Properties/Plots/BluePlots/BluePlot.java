package Board.Fields.Properties.Plots.BluePlots;


import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class
BluePlot extends Plot {

	BluePlot(Game game, String name){
		super(game, name, 1200, new int[]{50, 250, 750, 2250, 4000, 6000});
	}

}
