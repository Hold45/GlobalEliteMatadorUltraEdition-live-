package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay2000 extends ChanceCard {

    public Pay2000(Owner owner) {
        super(owner, "Pay2000CardDescription");
    }
    /**
     * Withdraws 2000 kr. from the player and deposits them in the bank
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),2000);
    }
}

