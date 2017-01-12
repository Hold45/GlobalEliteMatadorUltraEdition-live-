package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShip extends ChanceCard {

    public MoveToShip(Owner owner) {
        super(owner, "MoveToShipDescription");
    }
    /**
     * Moves the player to the nearest ship
     */
    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Ship.class));
    }

}

