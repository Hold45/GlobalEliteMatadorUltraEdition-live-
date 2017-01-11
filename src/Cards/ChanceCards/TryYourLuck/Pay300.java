package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay300 extends ChanceCard {

    public Pay300(Owner owner) {
        super(owner, "Pay300Description");
    }

    @Override
    public void draw(Player player) {
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),300);
    }
}

