package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class Gain500FromAll extends ChanceCard {

    public Gain500FromAll(Owner owner, String description) {
        super(owner, description);
    }

    @Override
    public void draw(Player player) {
        super.draw(player);
        for (Player other : player.getGame().getOtherPlayers(player)) {
            other.getAccount().transferTo(player.getAccount(), 500);

        }
    }
}
