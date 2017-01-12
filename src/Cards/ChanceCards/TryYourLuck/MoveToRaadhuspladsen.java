package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.BluePlots.BluePlot;
import Board.Fields.Properties.Plots.GreyPlots.Strandvejen;
import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Board.Fields.Properties.Ships.Ship;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToRaadhuspladsen extends ChanceCard {

    public MoveToRaadhuspladsen(Owner owner) {
        super(owner, "MoveToRådhuspladsenDescription");
    }

    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Raadhuspladsen.class));
    }

}

