package Game.Turns;

import Owners.Player;

/**
 *
 */
public class ScheduledTurn extends RegularTurn {

	public ScheduledTurn(Player owner) {
		super(owner);
	}

	@Override
	public void take() {
		super.take();
		this.owner.getGame().getTurns().push(this.owner.getGame().nextPlayer(this.owner).getTurn());
	}
}
