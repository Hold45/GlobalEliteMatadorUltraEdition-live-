package GUI;

import Game.Actions.Action;
import Owners.Player;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DummyGUI implements GUI{

	@Override
	public int getField(int[] options) {
		return 0;
	}

	@Override
	public Action chooseAction(Player player, Action... options) {
		return options[options.length-1];
	}
}