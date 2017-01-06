package Board.Fields.Properties.Plots.PurplePlot;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class PurplePlot extends Plot {
	
	PurplePlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, price, rentScheme);
	}
}
