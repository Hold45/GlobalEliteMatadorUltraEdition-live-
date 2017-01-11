package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Owners.Player;

/**
 *
 */
public class DowngradeProperty extends Action {
	public static final Action self = new DowngradeProperty();

	@Override
	public void run(Player player) {
		System.out.println("downgrade");
		((Deed) player.getGame().getGUI().chooseTradable(
				player,
				"chooseThatShit",
				player.getOwns().stream()
						.filter(tradable -> tradable instanceof Deed)
						.filter(tradable -> ((Deed)tradable).getProperty().canBeDowngraded())
						.toArray(Tradable[]::new)
		)).getProperty().tryDowngrade();
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
				.anyMatch(tradable -> ((Deed)tradable).getProperty().canBeDowngraded());
	}
}
