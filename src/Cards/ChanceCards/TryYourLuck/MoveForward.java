package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveForward extends ChanceCard {

    public MoveForward(Owner owner) {
        super(owner, "MoveForwardDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getOffsetPosition(3));
    }

}