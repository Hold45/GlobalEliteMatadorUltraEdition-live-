package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.BluePlots.BluePlot;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Plots.RedPlots.Groenningen;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToGroenningen extends ChanceCard {

    public MoveToGroenningen(Owner owner) {
        super(owner, "MoveToGroenningenDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Groenningen.class));
    }

}

