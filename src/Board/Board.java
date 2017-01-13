package Board;

import Board.Fields.*;
import Board.Fields.Properties.Brewery.*;
import Board.Fields.Properties.Plots.BluePlots.*;
import Board.Fields.Properties.Plots.GreenPlots.*;
import Board.Fields.Properties.Plots.GreyPlots.*;
import Board.Fields.Properties.Plots.OrangePlots.*;
import Board.Fields.Properties.Plots.PurplePlot.*;
import Board.Fields.Properties.Plots.RedPlots.*;
import Board.Fields.Properties.Plots.WhitePlots.*;
import Board.Fields.Properties.Plots.YellowPlots.*;
import Board.Fields.Properties.Ships.*;
import Game.Game;
import Owners.Player;

import java.awt.Color;
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
				new HelsingoerHelsingborg(game),
				new Roskildevej(game),
				new Chance(game),
				new ValbyLanggade(game),
				new Allegade(game),
				new Jail(game),
				new FrederiksbergAlle(game),
				new Squash(game),
				new Bulowsvej(game),
				new GammelKongevej(game),
				new Molslinien(game),
				new Bernstorffsvej(game),
				new Chance(game),
				new Hellerupvej(game),
				new Strandvejen(game),
				new Parking(game),
				new Trianglen(game),
				new Chance(game),
				new Oesterbrogade(game),
				new Groenningen(game),
				new GedserRostock(game),
				new Bredgade(game),
				new KongensNytorv(game),
				new CocaCola(game),
				new Oestergade(game),
				new GoToJail(game),
				new Amagertorv(game),
				new Vimmelskaftet(game),
				new Chance(game),
				new Nygade(game),
				new RoedbyPuttgarden(game),
				new Chance(game),
				new Frederiksberggade(game),
				new Tax(game),
				new Raadhuspladsen(game),
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

	private int getIndex(Class field, int startFrom){
		for (int i = 0; i < this.fields.length; i++){
			int x = Math.floorMod(i + startFrom,this.fields.length);
			if(field.isAssignableFrom(this.fields[x].getClass()))
				return x;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	private int getIndex(Field field, int startFrom){
		for (int i = 0; i < this.fields.length; i++){
			int x = Math.floorMod(i + startFrom,this.fields.length);
			if(this.fields[x].equals(field))
				return x;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	public int getIndex(Class field, Player player){
		return getIndex(field, player.getPosition());
	}

	public int getIndex(Class field){
		return getIndex(field, 0);
	}

	public int getIndex(Field field){
		return getIndex(field, 0);
	}

	public int getIndex(Field field, Player player){
		return getIndex(field, player.getPosition());
	}


	public Field getField(Class c){
		return Arrays.stream(this.fields).filter(field -> field.getClass().isAssignableFrom(c)).findFirst().orElseThrow(ArrayIndexOutOfBoundsException::new);
	}

	public Field getField(int index){
		return this.fields[index];
	}
}
