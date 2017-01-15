package Cards.ChanceCards.TryYourLuck;


import Board.Fields.Properties.Ships.Molslinien;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToMolsLinien extends ChanceCard {

    public MoveToMolsLinien(Owner owner) {
        super(owner, "MoveToMolsLinienCardDescription");
    }

    /**
     * Moves the player to Molslinien
     *
     * @param player who draws
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Molslinien.class);
    }

}

