package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToStrandvejen extends ChanceCard {

    public MoveToStrandvejen(Owner owner) {
        super(owner, "Card42Desc");
    }
    /**
     * Moves the player to Strandvejen
     */
    @Override
    public void draw(Player player) {
        player.move(player.getNextFieldOfType(Strandvejen.class));
    }

}

