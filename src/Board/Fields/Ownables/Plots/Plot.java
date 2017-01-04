package Board.Fields.Ownables.Plots;

import Board.Fields.Ownables.Ownable;
import Buildings.Building;
import Game.Game;

/**
 *
 */
public abstract class Plot extends Ownable {
	private int[] rentScheme;

	public Plot(Game game, String name, int price, int[] rentScheme) {
		super(game, name, "", price);
		this.rentScheme = rentScheme;
	}

	@Override
	public int getRent() {
		return this.rentScheme[this.buildings.stream().mapToInt(Building::getUpgradeValue).sum()];
	}

	public boolean tryUpgrade(){
		return true;
	}

}
