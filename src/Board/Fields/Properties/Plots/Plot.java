package Board.Fields.Properties.Plots;

import java.awt.Color;

import Board.Fields.Properties.Property;
import Buildings.Hotel;
import Buildings.House;
import Game.Game;

/**
 *
 */
public abstract class Plot extends Property {
	private int[] rentScheme;

	public Plot(Game game, String name, Color color, int price, int[] rentScheme) {
		super(game, name, "PlotDescription", color, price);
		this.rentScheme = rentScheme;

		this.upgradeSignature = new Class[][]{
				{},
				{House.class},
				{House.class, House.class},
				{House.class, House.class, House.class},
				{House.class, House.class, House.class, House.class},
				{Hotel.class}
		};

	}

	@Override
	public int getRent() {
		return this.rentScheme[getUpgradeValue()]*rentMultiplier();
	}

	private int rentMultiplier(){
		if (this.getFriends().count() == this.getOwnedFriends().count()){
			return 2;
		}
		return 1;
	}

	public int[] getRentScheme() {
		return this.rentScheme;
	}
}
