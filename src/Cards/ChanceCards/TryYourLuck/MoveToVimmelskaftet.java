package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Properties.Plots.YellowPlots.Vimmelskaftet;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToVimmelskaftet extends ChanceCard {

    public MoveToVimmelskaftet(Owner owner) {
        super(owner, "MoveToVimmelskaftetCardDescription");
    }
    /**
     * Moves the player to Vimmelskaftet
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Vimmelskaftet.class);
    }

}

