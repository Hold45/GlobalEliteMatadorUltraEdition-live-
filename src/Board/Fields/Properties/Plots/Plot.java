package Board.Fields.Properties.Plots;

import Board.Fields.Properties.Property;
import Buildings.Building;
import Game.Game;
import Owners.Player;

import java.util.Arrays;

/**
 *
 */
public abstract class Plot extends Property {
	private int[] rentScheme;

	public Plot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, "", price);
		this.rentScheme = rentScheme;
	}

	@Override
	public int getRent() {
		return this.rentScheme[getUpgradeValue()]*rentMultiplier();
	}

	private int rentMultiplier(){
		if(
			Arrays.stream(this.getGame().getBoard().getFields())
				.filter(field -> field.getClass().getSuperclass() == this.getClass().getSuperclass())
					.filter(field -> ((Plot)field).getDeed().getOwner() == this.getDeed().getOwner())
						.count()
														==
			Arrays.stream(this.getGame().getBoard().getFields())
					.filter(field -> field.getClass().getSuperclass() == this.getClass().getSuperclass())
						.count()
				){
			return 2;
		}
		return 1;
	}

	public int getUpgradeValue() {
		return this.buildings.stream()
					.mapToInt(Building::getUpgradeValue)
						.sum();
	}

	public boolean canUpgrade(){
		return getUpgradeValue() < 5 && this.getDeed().isPawned(); //TODO: move 5 to another place.
	}

	public boolean tryUpgrade(){
		return true;
	}

	public int[] getRentScheme() {
		return this.rentScheme;
	}
}
