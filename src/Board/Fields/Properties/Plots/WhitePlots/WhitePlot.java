package Board.Fields.Properties.Plots.WhitePlots;

import java.awt.Color;

import Board.Fields.Properties.Plots.Plot;
import Game.Game;

abstract class WhitePlot extends Plot {

	WhitePlot(Game game, String name, int price, int[] rentScheme) {
		super(game, name,Color.white, price, rentScheme);
	}

	WhitePlot(Game game, String name){
		super(game, name,Color.white, 5200, new int[]{450, 2200, 6600, 16000, 19500, 23000});
	}

	
}
