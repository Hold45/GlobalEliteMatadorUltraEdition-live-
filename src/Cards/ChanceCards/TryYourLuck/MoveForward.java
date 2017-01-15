package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveForward extends ChanceCard {

    public MoveForward(Owner owner) {
        super(owner, "MoveForwardCardDescription");
    }

    /**
     * Moves the player 3 spaces forward.
     *
     * @param player wh draws
     * @see Player#move(int)
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.move(3);
    }

}