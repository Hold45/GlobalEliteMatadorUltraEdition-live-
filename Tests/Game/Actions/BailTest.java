package Game.Actions;

import Game.SmartTemplateTest;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BailTest extends SmartTemplateTest{
	Action bail;

	@Before
	public void setup(){
		bail = Bail.self;
	}

	@After
	public void tearDown(){
		bail = null;
	}

	/**
	 * @see Bail#run(Player)
	 */
	@Test
	public void testRun() {
		p1.arrest();

		//Bails the player
		bail.run(p1);
		assertThat(p1.isJailed()).isFalse();
		assertThat(p1.getAccount().getBalance()).isEqualTo(9000);
	}

	/**
	 * @see Bail#runnable(Player)
	 */
	@Test
	public void testRunnable() {
		//Player isn't jailed
		assertThat(bail.runnable(p1)).isFalse();

		//Player is jailed, has enough money.
		p1.arrest();
		assertThat(bail.runnable(p1)).isTrue();

		//Player is jailed, but not enough money.
		p1.getAccount().setBalance(0);
		assertThat(bail.runnable(p1)).isFalse();
	}

}