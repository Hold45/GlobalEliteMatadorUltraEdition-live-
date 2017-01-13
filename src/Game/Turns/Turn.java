package Game.Turns;

import Owners.Player;

/**
 *
 */
public abstract class Turn {
	protected Player owner;

	public Turn(Player owner) {
		this.owner = owner;
	}

	public void take() {
		this.owner.getGame().getTurnLog().add(this);
	}

	public Player getOwner() {
		return this.owner;
	}
}
