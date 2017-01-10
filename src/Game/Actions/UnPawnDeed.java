package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Owners.Player;

/**
 *
 */
public class UnPawnDeed extends Action {
	public static final Action self = new UnPawnDeed();

	@Override
	public void run(Player player) {
		((Deed)player.getGame().getGUI().chooseTradable(
				player,
				"chose that shit!",
				player.getOwns().stream()
						.filter(tradable -> tradable instanceof Deed && ((Deed)tradable).canBeUnpawned())
						.toArray(Deed[]::new)
		)).tryUnpawn();
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
				.anyMatch(tradable -> ((Deed)tradable).canBeUnpawned());
	}
}
