package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain200 extends ChanceCard {

    public Gain200(Owner owner) {
        super(owner, "Gain200Description");
    }

    @Override
    public void draw(Player player) {
        player.getGame().getBank().getAccount().transferTo(player.getAccount(), 200);
    }
}
//1 kort