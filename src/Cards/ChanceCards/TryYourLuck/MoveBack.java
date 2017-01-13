package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveBack extends ChanceCard {

    public MoveBack(Owner owner) {
        super(owner, "Card22Desc");
    }

    @Override
    public void draw(Player player) {
        player.move(-3);
    }

}