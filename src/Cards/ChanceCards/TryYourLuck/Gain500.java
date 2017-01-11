package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain500 extends ChanceCard {

    public Gain500(Owner owner) {
        super(owner, "Gain1000Description");
    }

    @Override
    public void draw(Player player) {
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 500);
    }
}

//2 kort