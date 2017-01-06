package Game.Actions;

import Owners.Player;

/**
 *
 */
public class SellBuildingToBank implements Action {
	public static final Action self = new SellBuildingToBank();

	@Override
	public void run(Player player) {

	}

	@Override
	public boolean runnable(Player player) {
		return false;
	}
}
