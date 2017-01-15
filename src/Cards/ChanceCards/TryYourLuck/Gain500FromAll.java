package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain500FromAll extends ChanceCard {

    public Gain500FromAll(Owner owner) {
        super(owner, "Gain500CardFromAllDescription");
    }

	/**
	 * Gains 500 from all players
	 *
	 * @param player who draws
	 */
	@Override
    public void draw(Player player) {
        super.draw(player);
        player.getGame().getOtherPlayers(player)
                .forEach(other -> other.getAccount().transferTo(player.getAccount(), 500));
    }
}
