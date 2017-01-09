package Board;

import Board.Fields.Field;
import Board.Fields.Properties.Plots.YellowPlots.Amagertorv;
import Board.Fields.Properties.Plots.YellowPlots.Nygade;
import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaffet;
import Game.Game;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private Field[] fields;

	public Board(Game game) {
		fields = new Field[]{
				new Amagertorv(game),
				new Nygade(game),
				new Vimmelskaffet(game)
		};

	}

	public Field[] getFields() {
		return this.fields;
	}

	public int getIndex(Class field){
		for (int i = 0; i < this.fields.length; i++) {
			if(this.fields[i].getClass().isAssignableFrom(field)){
				return i;
			}
		}
		throw new ArithmeticException();
	}

	public Field getField(int index){
		return this.fields[index];
	}

	public int getIndex(Field field){
		return Arrays.asList(this.fields).indexOf(field);
	}
}
