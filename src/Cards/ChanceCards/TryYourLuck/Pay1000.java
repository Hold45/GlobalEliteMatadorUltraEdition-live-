package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Pay1000 extends ChanceCard {

    public Pay1000(Owner owner) {
        super(owner, "Pay1000Description");
    }

    @Override
    public void draw(Player player) {
        player.getAccount().transferTo(player.getGame().getBank().getAccount(),1000);
    }
}

//3 kort