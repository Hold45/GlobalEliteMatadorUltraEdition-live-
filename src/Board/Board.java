package Board;

import Board.Fields.Field;
import Board.Fields.Ownables.Plots.YellowPlots.Amagertorv;
import Board.Fields.Ownables.Plots.YellowPlots.Nygade;
import Board.Fields.Ownables.Plots.YellowPlots.VimmelSkaffet;
import Game.Game;

public class Board {
	private Field[] fields;

	public Board(Game game) {
		fields = new Field[]{
				new Amagertorv(game),
				new Nygade(game),
				new VimmelSkaffet(game)
		};

	}

}
