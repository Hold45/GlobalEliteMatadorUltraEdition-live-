package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain3000 extends ChanceCard {

    public Gain3000(Owner owner) {
        super(owner, "Gain3000Description");
    }

    @Override
    public void draw(Player player) {
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 3000);
    }
}

