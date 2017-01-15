package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShipX2 extends ChanceCard {

    public MoveToShipX2(Owner owner) {
        super(owner, "MoveToShipX2CardDescription");
    }

    /**
     * Moves the player to the nearest ship, checks if owned by another player
     * if it is, the player pays double rent
     */
    @Override
    public void draw(Player player) {
		super.draw(player);
	    player.moveTo(Ship.class);
	    Ship ship = (Ship) player.getGame().getBoard().getField(player.getPosition());

    	if(ship.getDeed().isPlayerOwned() && !ship.getDeed().getOwner().equals(player))
    		player.getAccount().transferTo( ((Player)ship.getDeed().getOwner()).getAccount(), ship.getRent());
    }

}

