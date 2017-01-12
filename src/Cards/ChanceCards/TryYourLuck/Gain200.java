package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain200 extends ChanceCard {

	    
    public Gain200(Owner owner) {
        super(owner, "Card1Desc");
    }
    /**
	 * Transfers 200 kr. from the bank to the player
	 */
    @Override
    public void draw(Player player) {
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 200);
    }
}
//1 kort