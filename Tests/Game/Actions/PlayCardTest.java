package Game.Actions;

import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.GetOutOfJailFree;
import Game.Actions.PlayCard;
import Game.SmartTemplateTest;
import org.junit.Test;
import Game.Actions.Action;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayCardTest extends SmartTemplateTest {

	@Test
	public void runTest(){
		ChanceCard bailCard = game.getCardPile().getOwns().stream().filter(card -> card instanceof GetOutOfJailFree).toArray(ChanceCard[]::new)[0];
		assertThat(game.getCardPile().isOwnerOf(bailCard)).isTrue();
		game.getCardPile().transferTradableTo(p1, bailCard);
		assertThat(p1.isOwnerOf(bailCard)).isTrue();
		assertThat(bailCard.getOwner()).isEqualTo(p1);
		assertThat(game.getCardPile().isOwnerOf(bailCard)).isFalse();
		assertThat(PlayCard.self.runnable(p1)).isFalse();
		p1.arrest();
		assertThat(PlayCard.self.runnable(p1)).isTrue();
		gui.addActions(bailCard);
		PlayCard.self.run(p1);
		//assertThat(p1.isJailed()).isFalse();
	}
}