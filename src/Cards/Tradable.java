package Cards;

import Owners.Owner;

/**
 *
 */
public abstract class Tradable {
	protected Owner owner;

	public Tradable(Owner owner){
		this.owner = owner;
	}

	public abstract boolean canBeTraded();

	public Owner getOwner() {
		return this.owner;
	}
}
