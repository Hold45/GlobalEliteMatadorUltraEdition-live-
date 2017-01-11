package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShip extends ChanceCard {

    public MoveToShip(Owner owner) {
        super(owner, "MoveToShipDescription");
    }

    @Override
    public void draw(Player player) {
        // find om felt er eget: player.getNextFieldOfType()
        player.moveTo(player.getNextFieldOfType(Ship.class));
    }

}

