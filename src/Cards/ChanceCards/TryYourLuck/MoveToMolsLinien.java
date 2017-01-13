package Cards.ChanceCards.TryYourLuck;


import Board.Fields.Properties.Ships.Molslinien;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToMolsLinien extends ChanceCard {

    public MoveToMolsLinien(Owner owner) {
        super(owner, "Card40Desc");
    }

    /**
     * Moves the player to Molslinien
     */
    @Override
    public void draw(Player player) {
        super.draw(player);
        player.move(Molslinien.class);
    }

}

