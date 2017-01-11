package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay2000 extends ChanceCard {

    public Pay2000(Owner owner) {
        super(owner, "Pay2000Description");
    }

    @Override
    public void draw(Player player) {
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),2000);
    }
}

