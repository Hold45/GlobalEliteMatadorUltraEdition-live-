package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.BluePlots.BluePlot;
import Board.Fields.Properties.Plots.GreenPlots.FrederiksbergAlle;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToFrederiksbergAlle extends ChanceCard {

    public MoveToFrederiksbergAlle(Owner owner) {
        super(owner, "MoveToFrederiksbergAlleDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(FrederiksbergAlle.class));
    }

}

