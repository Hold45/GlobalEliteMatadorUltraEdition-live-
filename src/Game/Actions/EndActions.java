package Game.Actions;

import Owners.Player;

/**
 *
 */
public class EndActions extends Action {
	public static final Action self = new EndActions();

	@Override
	public void run(Player player) {

	}

	@Override
	public boolean runnable(Player player) {
		return true;
	}
}
