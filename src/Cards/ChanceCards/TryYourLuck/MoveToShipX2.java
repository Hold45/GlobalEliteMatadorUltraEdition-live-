package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShipX2 extends ChanceCard {

    public MoveToShipX2(Owner owner) {
        super(owner, "MoveToShipX2Description");
    }
    /**
     * Moves the player to the nearest ship, checks if owned
     *  if it is the player pays double rent
     */
    @Override
    public void draw(Player player) {
        // find om felt er eget: player.getNextFieldOfType()
        player.moveTo(player.getNextFieldOfType(Ship.class));
    }

}

