package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveForward extends ChanceCard {

    public MoveForward(Owner owner) {
        super(owner, "Card21Desc");
    }
    /**
     * This method moves the player forward, using the getOffsetPosition method from player
     * @see Player#getOffsetPosition()
     */

    @Override
    public void draw(Player player) {
        player.moveTo(player.getOffsetPosition(3));
    }

}