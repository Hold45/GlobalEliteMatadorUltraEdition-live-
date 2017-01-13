package Game.Turns;

import Owners.Player;

/**
 * 
 */
public abstract class Turn {
	protected Player owner;
	/**
	 * The person who is taking the turn
	 * @param owner that is going to take a turn
	 */
	public Turn(Player owner) {
		this.owner = owner;
	}
	/**
	 * When this turn has been taken it will be added to the log of moves.
	 */
	public void take() {
		this.owner.getGame().getTurnLog().add(this);
	}

	public Player getOwner() {
		return this.owner;
	}
}
