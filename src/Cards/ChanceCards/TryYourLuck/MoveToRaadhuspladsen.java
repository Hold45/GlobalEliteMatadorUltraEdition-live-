package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.PurplePlot.Raadhuspladsen;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToRaadhuspladsen extends ChanceCard {

    public MoveToRaadhuspladsen(Owner owner) {
        super(owner, "MoveToRådhuspladsenDescription");
    }

    /**
     * Moves the player to Rådhuspladsen
     */
    @Override
    public void draw(Player player) {
        player.move(Raadhuspladsen.class);
    }

}

