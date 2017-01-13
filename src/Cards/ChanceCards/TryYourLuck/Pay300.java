package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay300 extends ChanceCard {

    public Pay300(Owner owner) {
        super(owner, "Card16Desc");
    }
    /**
     * Withdraws 300 kr. from the player and deposits them in the bank
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),300);
    }
}

