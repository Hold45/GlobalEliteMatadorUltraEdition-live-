package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay200 extends ChanceCard {

    public Pay200(Owner owner) {
        super(owner, "Pay200CardDescription");
    }

    /**
     * Withdraws 200 from the player and deposits them in the bank
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),200);
    }
}