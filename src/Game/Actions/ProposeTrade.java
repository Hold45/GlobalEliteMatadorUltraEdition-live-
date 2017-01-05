package Game.Actions;

import Cards.Tradable;
import Owners.Player;

/**
 *
 */
public class ProposeTrade implements Action{
	public static final Action self = new ProposeTrade();

	@Override
	public void run(Player player) {
		Tradable chosenTradable = player.getGame().getGUI().chooseTradable(player, "ChooseTradableSell",player.getOwns().stream().filter(Tradable::canBeTraded).toArray(Tradable[]::new));
		Player tradePartner = player.getGame().getGUI().choosePlayer(player, "ChooseSellToPlayer", player.getGame().getPlayers().stream().filter(other -> other != player).toArray(Player[]::new));
		int price = player.getGame().getGUI().selectPayment(player,"ChooseSellPrice", tradePartner.getAccount());

		assert tradePartner.getAccount().getBalance() < price;
		tradePartner.getAccount().transferTo(player.getAccount(), price);
		player.transferTradableTo(tradePartner, chosenTradable);
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream().anyMatch(Tradable::canBeTraded);
	}
}
