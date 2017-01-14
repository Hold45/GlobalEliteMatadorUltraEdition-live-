package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToRaadhuspladsen extends ChanceCard {

    public MoveToRaadhuspladsen(Owner owner) {
        super(owner, "Card39Desc");
    }

    /**
     * Moves the player to Raadhuspladsen
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Raadhuspladsen.class);
    }

}

