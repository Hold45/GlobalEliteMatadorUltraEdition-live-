package Cards.ChanceCards.TryYourLuck;


import Board.Fields.Properties.Plots.RedPlots.Groenningen;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToGroenningen extends ChanceCard {

    public MoveToGroenningen(Owner owner) {
        super(owner, "Card37Desc");
    }
    /**
     * Moves the player to Grønningen
     */
    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(Groenningen.class));
    }

}

