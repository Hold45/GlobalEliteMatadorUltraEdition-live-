package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain1000 extends ChanceCard {

    public Gain1000(Owner owner) {
        super(owner, "Gain1000Description");
    }

    @Override
    public void draw(Player player) {
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 1000);
    }
}

//8 kort