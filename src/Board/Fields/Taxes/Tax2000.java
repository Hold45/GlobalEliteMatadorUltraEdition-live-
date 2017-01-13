package Board.Fields.Taxes;

import Game.Game;
import Owners.Player;

import java.awt.*;


public class Tax2000 extends Tax {

	public Tax2000(Game game) {
        super(game, "TaxName2000", "TaxDescription2000");
    }

	@Override
	public int getTax(Player player) {
		return 2000;
	}
}