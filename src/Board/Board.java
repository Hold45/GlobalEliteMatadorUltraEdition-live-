package Board;

import Board.Fields.Field;
import Board.Fields.Properties.Plots.YellowPlots.Amagertorv;
import Board.Fields.Properties.Plots.YellowPlots.Nygade;
import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaffet;
import Game.Game;

public class Board {
	private Field[] fields;

	public Board(Game game) {
		fields = new Field[]{
				new Amagertorv(game),
				new Nygade(game),
				new Vimmelskaffet(game)
		};

	}

}
