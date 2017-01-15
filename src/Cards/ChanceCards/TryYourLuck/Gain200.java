package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain200 extends ChanceCard {

	    
    public Gain200(Owner owner) {
        super(owner, "Gain200CardDescription");
    }

    /**
	 * Transfers 200 from the bank to the player
     *
     * @param player who draws
	 */
    @Override
    public void draw(Player player) {
    	super.draw(player);
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 200);
    }
}