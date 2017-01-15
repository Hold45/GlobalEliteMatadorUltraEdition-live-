package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain500 extends ChanceCard {

    public Gain500(Owner owner) {
        super(owner, "Gain500CardDescription");
    }

	/**
	 * Transfers 500 from the bank to the player
	 *
	 * @param player who draws
	 */
	@Override
    public void draw(Player player) {
		super.draw(player);
		player.getGame().getBank().getAccount().transferTo(player.getAccount(), 500);
    }
}
