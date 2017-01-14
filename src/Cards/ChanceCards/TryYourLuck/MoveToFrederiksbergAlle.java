package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.GreenPlots.FrederiksbergAlle;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToFrederiksbergAlle extends ChanceCard {

    public MoveToFrederiksbergAlle(Owner owner) {
        super(owner, "Card36Desc");
    }
/**
 * Moves the player to Frederiksberg All
 */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo((FrederiksbergAlle.class));
    }

}

