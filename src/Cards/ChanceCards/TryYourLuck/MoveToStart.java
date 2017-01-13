package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Board.Fields.Start;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToStart extends ChanceCard {

    public MoveToStart(Owner owner) {
        super(owner, "Card43Desc");
    }

    @Override
    public void draw(Player player) {
        player.move(player.getNextFieldOfType(Start.class));
    }

}

// 2 Kort