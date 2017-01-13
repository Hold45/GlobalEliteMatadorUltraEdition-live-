package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Property;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProposeTradeTest extends SmartTemplateTest {

	@Test
	public void testRun() throws Exception{
		Deed deed = ((Property)game.getBoard().getField(Hvidovrevej.class)).getDeed();
		game.getBank().transferTradableTo(p1, deed);

		gui.addActions(EndActions.self, EndActions.self, true, 1000, p2, deed, ProposeTrade.self);

		p1.takeActions(ProposeTrade.self);

		assertThat(p1.getAccount().getBalance()).isEqualTo(11000);
		assertThat(p1.isOwnerOf(deed)).isFalse();
		assertThat(p2.getAccount().getBalance()).isEqualTo(9000);
		assertThat(p2.isOwnerOf(deed)).isTrue();
	}

}