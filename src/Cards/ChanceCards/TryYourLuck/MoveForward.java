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
     * @see Player#move(int)
     */

    @Override
    public void draw(Player player) {
        super.draw(player);
        player.move(3);
    }

}