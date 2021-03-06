package Board.Fields.Properties.Plots;

import Board.Fields.Properties.Property;
import Buildings.Hotel;
import Buildings.House;
import Game.Game;

import java.awt.*;

/**
 *
 */
public abstract class Plot extends Property {
	private int[] rentScheme;

	public Plot(Game game, String name, Color color, int price, int upgradePrice, int[] rentScheme) {
		super(game, name, "PlotDescription", color, price, upgradePrice);
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
		return this.getRentScheme()[getUpgradeValue()]*rentMultiplier();
	}

	private int rentMultiplier(){
		if (
			this.getFriends().count() == this.getOwnedFriends().count()
			&& this.getUpgradeValue() == 0
		){
			return 2;
		}
		return 1;
	}

	public int[] getRentScheme() {
		return this.rentScheme;
	}
}
