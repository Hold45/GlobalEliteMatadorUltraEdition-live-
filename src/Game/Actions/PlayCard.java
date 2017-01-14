package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.GetOutOfJailFree;
import Cards.Tradable;
import Owners.Player;

public class PlayCard extends Action {
	public static final Action self = new PlayCard();

	@Override
	public void run(Player player) {
		ChanceCard chosenCard = (ChanceCard) player.getGame().getGUI().chooseTradable(
			player,
			"ChooseCardPlay",
			player.getOwns().stream()
				.filter(tradable -> tradable instanceof ChanceCard)
				.filter(card -> ((ChanceCard)card).canBePlayed())
				.toArray(ChanceCard[]::new));
		chosenCard.play();
	}

	@Override
	public boolean runnable(Player player) {
		return player.getOwns().stream()
			.filter(tradable -> tradable instanceof ChanceCard)
			.anyMatch(card -> ((ChanceCard)card).canBePlayed());
	}
}
