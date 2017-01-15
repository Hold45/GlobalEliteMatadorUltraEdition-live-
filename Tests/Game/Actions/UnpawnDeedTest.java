package Game.Actions;

import Board.Fields.Properties.Deeds.Deed;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Board.Fields.Properties.Plots.BluePlots.Roedovrevej;
import Board.Fields.Properties.Plots.Plot;
import Game.SmartTemplateTest;
import Owners.Accountable;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UnpawnDeedTest extends SmartTemplateTest{
	private Deed hvidovrevej;
	private Deed roedovrevej;
	Action unpawn;

	@Before
	public void setup(){
		hvidovrevej = ((Plot) game.getBoard().getField(Hvidovrevej.class)).getDeed();
		roedovrevej = ((Plot) game.getBoard().getField(Roedovrevej.class)).getDeed();
		unpawn = UnpawnDeed.self;
	}

	@After
	public void tearDown(){
		hvidovrevej = null;
		roedovrevej = null;
		unpawn = null;
	}

	/**
	 * @see UnpawnDeed#run(Player)
	 */
	@Test
	public void testRun() {
		roedovrevej.tryPurchase(p1);
		roedovrevej.tryPawn();
		int beforeBalance = p1.getAccount().getBalance();

		gui.addActions(roedovrevej);
		unpawn.run(p1);
		assertThat(p1.getAccount().getBalance()).isEqualTo(beforeBalance-(int)(roedovrevej.getPrice()*0.55));
	}

	/**
	 * @see UnpawnDeed#runnable(Player)
	 */
	@Test
	public void testRunnable() {
		//Owning no deeds and no deeds pawned
		assertThat(unpawn.runnable(p1)).isFalse();

		//Owning no deeds, but deeds are pawned.
		hvidovrevej.setOwner(p2);
		hvidovrevej.tryPawn();
		assertThat(unpawn.runnable(p1)).isFalse();

		//Owning a deed, but not pawned.
		roedovrevej.tryPurchase(p1);
		assertThat(unpawn.runnable(p1)).isFalse();

		//Owning a deed and pawned.
		roedovrevej.tryPawn();
		assertThat(unpawn.runnable(p1)).isTrue();
	}

}