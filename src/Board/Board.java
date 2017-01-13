package Board;

import Board.Fields.Chance;
import Board.Fields.Field;
import Board.Fields.Jail;
import Board.Fields.Start;
import Board.Fields.Tax;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Plots.GreenPlots.Bulowsvej;
import Board.Fields.Properties.Plots.GreenPlots.FrederiksbergAlle;
import Board.Fields.Properties.Plots.GreenPlots.GammelKongevej;
import Board.Fields.Properties.Plots.GreyPlots.Bernstorffsvej;
import Board.Fields.Properties.Plots.GreyPlots.Hellerupvej;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Plots.OrangePlots.Allegade;
import Board.Fields.Properties.Plots.OrangePlots.Roskildevej;
import Board.Fields.Properties.Plots.OrangePlots.ValbyLanggade;
import Board.Fields.Properties.Plots.PurplePlot.Frederiksberggade;
import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Board.Fields.Properties.Plots.RedPlots.Groenningen;
import Board.Fields.Properties.Plots.RedPlots.Oesterbrogade;
import Board.Fields.Properties.Plots.RedPlots.Trianglen;
import Board.Fields.Properties.Plots.WhitePlots.Bredgade;
import Board.Fields.Properties.Plots.WhitePlots.KongensNytorv;
import Board.Fields.Properties.Plots.WhitePlots.Oestergade;
import Board.Fields.Properties.Plots.YellowPlots.Amagertorv;
import Board.Fields.Properties.Plots.YellowPlots.Nygade;
import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaftet;
import Board.Fields.Properties.Ships.HelsingoerHelsingborg;
import Game.Game;

import java.util.Arrays;

public class Board {
	private Field[] fields;

	public Board(Game game) {
		fields = new Field[]{
				new Start(game),
				new Roedovrevej(game),
				new Chance(game),
				new Hvidovrevej(game),
				new Tax(game),
				//new HelsingoerHelsingborg(game),
				new Roskildevej(game),
				new Chance(game),
				new ValbyLanggade(game),
				new Allegade(game),
				new Jail(game),
				new FrederiksbergAlle(game),
				new Bulowsvej(game),
				new GammelKongevej(game),
				new Bernstorffsvej(game),
				new Hellerupvej(game),
				new Strandvejen(game),
				new Trianglen(game),
				new Oesterbrogade(game),
				new Groenningen(game),
				new Bredgade(game),
				new KongensNytorv(game),
				new Oestergade(game),
				new Amagertorv(game),
				new Vimmelskaftet(game),
				new Nygade(game),
				new Frederiksberggade(game),
				new Raadhuspladsen(game)
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
		throw new ArrayIndexOutOfBoundsException();
	}

	public Field getField(Class c){
		return Arrays.stream(this.fields).filter(field -> field.getClass().isAssignableFrom(c)).findFirst().orElseThrow(ArrayIndexOutOfBoundsException::new);
	}

	public Field getField(int index){
		return this.fields[index];
	}

	public int getIndex(Field field){
		return Arrays.asList(this.fields).indexOf(field);
	}
}
