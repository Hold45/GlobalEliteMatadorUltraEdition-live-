package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay1000 extends ChanceCard {

    public Pay1000(Owner owner) {
        super(owner, "Pay1000CardDescription");
    }
/**
 * Withdraws 1000 kr. from the player and deposits them in the bank
 */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),1000);
    }
}

//3 kort