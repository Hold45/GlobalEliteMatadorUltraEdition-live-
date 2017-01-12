package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.BluePlots.BluePlot;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToStrandvejen extends ChanceCard {

    public MoveToStrandvejen(Owner owner) {
        super(owner, "MoveToStrandvejenDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Strandvejen.class));
    }

}

