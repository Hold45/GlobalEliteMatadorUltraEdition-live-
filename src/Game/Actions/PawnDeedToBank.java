package Game.Actions;

import Owners.Player;

/**
 *
 */
public class PawnDeedToBank implements Action {
	public static final Action self = new PawnDeedToBank();

	@Override
	public void run(Player player) {

	}

	@Override
	public boolean runnable(Player player) {
		return false;
	}
}
