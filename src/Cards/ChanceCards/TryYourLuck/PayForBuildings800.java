package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Deeds.Deed;
import Buildings.Building;
import Buildings.Hotel;
import Buildings.House;
import Cards.ChanceCards.ChanceCard;
import Cards.Tradable;
import Owners.Owner;
import Owners.Player;

public class PayForBuildings800 extends ChanceCard {

    public PayForBuildings800(Owner owner) {
        super(owner, "PayForBuildings800Description");
    }
    /**
     * Makes the player pay for every house and hotel they own
     * The player pays 800 kr. for each house
     * The player pays 2300 kr. for each hotel
     */
    @Override
    public void draw(Player player) {
        int sum = 0;
        for (Tradable tradable : player.getOwns()){
            if (tradable instanceof Deed){
                for (Building building : ((Deed) tradable).getProperty().getBuildings()){
                    if (building instanceof House){
                        sum += 800;
                    } else if (building instanceof Hotel){
                        sum += 2300;
                    }
                }
            }
        }
        player.getAccount().transferTo(player.getGame().getBank().getAccount(), sum);
    }
}

