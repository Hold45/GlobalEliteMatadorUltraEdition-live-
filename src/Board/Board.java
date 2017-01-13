package Board;

import Board.Fields.*;
import Board.Fields.LawInforcment.GoToJail;
import Board.Fields.LawInforcment.Jail;
import Board.Fields.Properties.Brewery.CocaCola;
import Board.Fields.Properties.Brewery.Squash;
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
import Board.Fields.Properties.Ships.GedserRostock;
import Board.Fields.Properties.Ships.HelsingoerHelsingborg;
import Board.Fields.Properties.Ships.Molslinien;
import Board.Fields.Properties.Ships.RoedbyPuttgarden;
import Board.Fields.Taxes.Tax2000;
import Board.Fields.Taxes.Tax4000;
import Game.Game;
import Owners.Player;

import java.util.Arrays;

public class Board {
	private Field[] fields;

	public Board(Game game) {
		fields = new Field[]{
				new Start(game),
				new Roedovrevej(game),
				new Chance(game),
				new Hvidovrevej(game),
				new Tax4000(game),
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
				new Tax2000(game),
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
