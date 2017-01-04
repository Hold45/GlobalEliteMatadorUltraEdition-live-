package Game;

import Owners.Player;

/**
 *
 */
public abstract class AdditionalTurn extends Turn {
	public AdditionalTurn(Player owner) {
		super(owner);
	}

	@Override
	public void take() {

	}
}
