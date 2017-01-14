package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShip extends ChanceCard {

    public MoveToShip(Owner owner) {
        super(owner, "Card38Desc");
    }

    /**
     * Moves the player to the nearest ship
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Ship.class);
    }

}

