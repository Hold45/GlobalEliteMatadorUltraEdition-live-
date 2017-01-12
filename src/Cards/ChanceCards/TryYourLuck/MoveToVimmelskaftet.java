package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.BluePlots.BluePlot;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaftet;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToVimmelskaftet extends ChanceCard {

    public MoveToVimmelskaftet(Owner owner) {
        super(owner, "MoveToVimmelskaftetDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Vimmelskaftet.class));
    }

}

