package Cards.ChanceCards.TryYourLuck;
import Owners.*;
import Board.Fields.Properties.Property;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToShipX2 extends ChanceCard {

    public MoveToShipX2(Owner owner) {
        super(owner, "Card44Desc");
    }

    /**
     * Moves the player to the nearest ship, checks if owned by another player
     * if it is, the player pays double rent
     */
    @Override
    public void draw(Player player) {
	    player.move(Ship.class);
	    Ship ship = (Ship) player.getGame().getBoard().getField(player.getPosition());

    	if(ship.getDeed().isPlayerOwned() && !ship.getDeed().getOwner().equals(player))
    		player.getAccount().transferTo( ((Player)ship.getDeed().getOwner()).getAccount(), ship.getRent());
    }

}

