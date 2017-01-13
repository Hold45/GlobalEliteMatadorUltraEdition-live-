package Board.Fields;

import Game.Game;
import Owners.Player;

/**
 * Created by JAL on 12/01/2017.
 */
public class Start extends Field {
    public Start(Game game) {
        super(game, "FieldStart", "description");
    }

    @Override
    public void onMoveOver(Player player) {
        super.onMoveOver(player);
        this.game.getBank().getAccount().transferTo(player.getAccount(), 4000);
    }
}
