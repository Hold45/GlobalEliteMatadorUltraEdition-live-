package Cards.ChanceCards.TryYourLuck;


import Board.Fields.Properties.Ships.MolsLinien;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToMolsLinien extends ChanceCard {

    public MoveToMolsLinien(Owner owner) {
        super(owner, "MoveToMolsLinienDescription");
    }
    /**
     * Moves the player to Molslinien
     */
    @Override
    public void draw(Player player) {
        player.moveTo(player.getNextFieldOfType(MolsLinien.class));
    }

}

