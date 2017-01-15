package Cards.ChanceCards.TryYourLuck;


import Board.Fields.Properties.Plots.RedPlots.Groenningen;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToGroenningen extends ChanceCard {

    public MoveToGroenningen(Owner owner) {
        super(owner, "MoveToGroenningenCardDescription");
    }

    /**
     * Moves the player to Groenningen.
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Groenningen.class);
    }

}

