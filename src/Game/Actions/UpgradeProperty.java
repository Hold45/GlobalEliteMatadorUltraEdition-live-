package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Owners.Player;


/**
 *
 */
public class UpgradeProperty extends Action {
	public static final Action self = new UpgradeProperty();

	@Override
	public void run(Player player) {
		System.out.println("upgrade");
		((Deed) player.getGame().getGUI().chooseTradable(
				player,
				"chooseThatShit",
				player.getOwns().stream()
					.filter(tradable -> tradable instanceof Deed)
						.filter(tradable -> ((Deed)tradable).getProperty().canBeUpgraded())
							.toArray(Tradable[]::new)
		)).getProperty().tryUpgrade();
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
					.anyMatch(tradable -> ((Deed)tradable).getProperty().canBeUpgraded());
	}
}
