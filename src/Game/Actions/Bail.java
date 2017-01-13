package Game.Actions;

import Owners.Player;

/**
 *
 */
public class Bail extends Action {
	public static final Action self = new Bail();

	/**
	 *
	 * @param player taking the action
	 */
	@Override
	public void run(Player player) {
		if (player.getAccount().payTo(player.getGame().getBank().getAccount(), 1000)){
			player.release();
		}
	}

	@Override
	public boolean runnable(Player player) {
		return player.isJailed();
	}
}
