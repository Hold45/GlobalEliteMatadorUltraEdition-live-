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

	/**
	 * Test if the player can play cards in their possession.
	 *
	 * @see PlayCard
	 *
	 */
	@Test
	public void runTest(){
		ChanceCard bailCard = game.getCardPile().getOwns().stream().filter(card -> card instanceof GetOutOfJailFree).toArray(ChanceCard[]::new)[0];
		//The card pile is the original owner of the getoutofjailfree card
		assertThat(game.getCardPile().isOwnerOf(bailCard)).isTrue();

		//Transfer card to player
		game.getCardPile().transferTradableTo(p1, bailCard);
		assertThat(p1.isOwnerOf(bailCard)).isTrue();
		assertThat(game.getCardPile().isOwnerOf(bailCard)).isFalse();

		//Card can not be played before the player is arrested
		assertThat(PlayCard.self.runnable(p1)).isFalse();

		//Arrest the player, now the card can be played
		p1.arrest();
		assertThat(PlayCard.self.runnable(p1)).isTrue();

		//Play the card
		gui.addActions(bailCard);
		PlayCard.self.run(p1);

		//The player got out of jail, and the cardpile owns the card again
		assertThat(p1.isJailed()).isFalse();
		assertThat(bailCard.getOwner()).isEqualTo(game.getCardPile());
	}
}