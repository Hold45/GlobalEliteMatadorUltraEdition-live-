package Game;

import GUI.DummyGUI;
import Owners.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest extends DumTemplateTest{

	@Test
	public void testStart() throws Exception {
		for (int i = 0; i < 100; i++) {
			game.start();
		}
	}

}