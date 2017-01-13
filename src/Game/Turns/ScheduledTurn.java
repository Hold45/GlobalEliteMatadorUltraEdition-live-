package Game.Turns;

import Owners.Player;

/**
 *
 */
public class ScheduledTurn extends RegularTurn {
	/**
	 * the person who is taking this turn
	 * @param owner that is going to take the turn
	 */
	public ScheduledTurn(Player owner) {
		super(owner);
	}
	
	/**
	 * This gets the current turn and changes so that the next player up will get their turn.
	 */
	@Override
	public void take() {
		this.owner.getGame().getTurns().push(this.owner.getGame().nextPlayer(this.owner).getTurn());
		super.take();
	}
}
