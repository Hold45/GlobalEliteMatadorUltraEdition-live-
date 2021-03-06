package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Deeds.Deed;
import Buildings.Building;
import Buildings.Hotel;
import Buildings.House;
import Cards.ChanceCards.ChanceCard;
import Cards.Tradable;
import Owners.Owner;
import Owners.Player;

public class PayForBuildings500 extends ChanceCard {

    public PayForBuildings500(Owner owner) {
        super(owner, "PayForBuildings500CardDescription");
    }

    /**
     * Makes the player pay for every house and hotel they own
     * The player pays 500 for each house
     * The player pays 2000 for each hotel
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        int sum = 0;

        for (Tradable tradable : player.getOwns()){
            if (tradable instanceof Deed){
                for (Building building : ((Deed) tradable).getProperty().getBuildings()){
                    if (building instanceof House){
                        sum += 500;
                    } else if (building instanceof Hotel){
                        sum += 2000;
                    }
                }
            }
        }
        player.getAccount().transferTo(player.getGame().getBank().getAccount(), sum);
    }
}

