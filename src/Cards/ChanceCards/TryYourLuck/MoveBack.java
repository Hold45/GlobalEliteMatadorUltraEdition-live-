package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveBack extends ChanceCard {

    public MoveBack(Owner owner) {
        super(owner, "MoveBackCardDescription");
    }

    /**
     * Moves the player 3 spaces back.
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.move(-3);
    }

}