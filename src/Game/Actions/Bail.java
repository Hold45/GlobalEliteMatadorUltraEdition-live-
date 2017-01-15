package Game.Actions;

import Owners.Player;

/**
 *
 */
public class Bail extends Action {
	public static final Action self = new Bail();

	/**
	 * Pays the bank the bailout amount and releases the player.
	 *
	 * @param player taking the action
	 */
	@Override
	public void run(Player player) {
		player.tryBail();
	}

	/**
	 * Checks if the given player is eligible for getting bailed.
	 *
	 * @param player checking if can be bailed
	 * @return true if bailable
	 */
	@Override
	public boolean runnable(Player player) {
		return player.isBailable();
	}
}
