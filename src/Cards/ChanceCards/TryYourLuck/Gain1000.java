package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain1000 extends ChanceCard {

    public Gain1000(Owner owner) {
        super(owner, "Gain1000CardDescription");
    }

    /**
     * Transfers 1000 from the bank to the player
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 1000);
    }
}

//8 kort