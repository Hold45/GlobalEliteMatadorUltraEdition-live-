package Cards.ChanceCards.TryYourLuck;

import Board.Fields.Start;
import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class MoveToStart extends ChanceCard {

    public MoveToStart(Owner owner) {
        super(owner, "MoveToStartCardDescription");
    }

    @Override
    public void draw(Player player) {
        super.draw(player);
        player.moveTo(Start.class);
    }

}