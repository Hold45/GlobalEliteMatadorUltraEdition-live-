package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Owners.Player;

/**
 *
 */
public class PawnDeed extends Action {
	public static final Action self = new PawnDeed();

	@Override
	public void run(Player player) {
		((Deed)player.getGame().getGUI().chooseTradable(
				player,
				"chose that shit!",
				player.getOwns().stream()
					.filter(tradable -> tradable instanceof Deed && ((Deed)tradable).canBePawned())
						.toArray(Deed[]::new)
		)).tryPawn();
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
					.anyMatch(tradable -> ((Deed)tradable).canBePawned());
	}
}
