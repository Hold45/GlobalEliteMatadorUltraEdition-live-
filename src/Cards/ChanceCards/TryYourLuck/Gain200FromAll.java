package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain200FromAll extends ChanceCard {

	public Gain200FromAll(Owner owner) {
		super(owner, "Gain200FromAllDescription");
	}
	/**
	 * Transfers 200 kr. from each of the other players, to this player
	 * The bank do not transfer anything
	 */
	@Override
	public void draw(Player player) {
		for (Player other : player.getGame().getOtherPlayers(player)) {
			other.getAccount().transferTo(player.getAccount(), 200);

		}
	}
}
