package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Owners.Player;

/**
 *
 */
public class SellDeedToBank extends Action {
	public static final Action self = new SellDeedToBank();

	@Override
	public void run(Player player) {
		Tradable chosenTradable = player.getGame().getGUI().chooseTradable(
				player,
				"ChooseTradableSell",
				player.getOwns().stream()
						.filter(tradable -> tradable instanceof Deed)
							.filter(Tradable::canBeTraded)
								.toArray(Tradable[]::new));

		chosenTradable.purchase(player.getGame().getBank());
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
					.anyMatch(Tradable::canBeTraded);
	}
}
