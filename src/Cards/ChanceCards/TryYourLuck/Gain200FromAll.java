package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain200FromAll extends ChanceCard {

    public Gain200FromAll(Owner owner) {
        super(owner, "Gain200CardFromAllDescription");
    }


	/**
	 * Draws 200 from all the other players in the game.
	 *
	 * @param player who draws
	 */
	@Override
    public void draw(Player player) {
        super.draw(player);
        player.getGame().getOtherPlayers(player)
		        .forEach(other -> other.getAccount().transferTo(player.getAccount(), 200));
    }
}