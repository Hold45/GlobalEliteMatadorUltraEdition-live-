package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay3000 extends ChanceCard {

    public Pay3000(Owner owner) {
        super(owner, "Card17Desc");
    }
    /**
     * Withdraws 3000 kr. from the player and deposits them in the bank
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),3000);
    }
}

//2 kort