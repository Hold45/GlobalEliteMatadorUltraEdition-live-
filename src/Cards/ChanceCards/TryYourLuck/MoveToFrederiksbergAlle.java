package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.GreenPlots.FrederiksbergAlle;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToFrederiksbergAlle extends ChanceCard {

    public MoveToFrederiksbergAlle(Owner owner) {
        super(owner, "MoveToFredriksbersAlleCardDescription");
    }

    /**
     * Moves the player to Frederiksberg All
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo((FrederiksbergAlle.class));
    }

}

