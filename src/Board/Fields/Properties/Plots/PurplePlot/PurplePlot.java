package Board.Fields.Properties.Plots.PurplePlot;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

import java.awt.*;

abstract class PurplePlot extends Plot {
	
	PurplePlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, Color.magenta, price, 4000, rentScheme);
	}
}
