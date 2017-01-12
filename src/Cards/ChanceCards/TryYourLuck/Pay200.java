package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay200 extends ChanceCard {

    public Pay200(Owner owner, String description) {
        super(owner, description);
    }
    /**
     * Withdraws 200 kr. from the player and deposits them in the bank
     */
    @Override
    public void draw(Player player) {
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),200);
    }
}

//3 kort