package Board.Fields.Taxes;

import Game.Game;
import Owners.Player;

public class Tax4000 extends Tax {

	public Tax4000(Game game) {
		super(game, "TaxName4000", "TaxDescription4000");
	}

	@Override
	public int getTax(Player player) {
		return 4000;
	}
}