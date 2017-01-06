package Game.Actions;

import Owners.Player;

/**
 *
 */
public class SellDeedsToBank implements Action {
	public static final Action self = new SellDeedsToBank();

	@Override
	public void run(Player player) {

	}

	@Override
	public boolean runnable(Player player) {
		return false;
	}
}
