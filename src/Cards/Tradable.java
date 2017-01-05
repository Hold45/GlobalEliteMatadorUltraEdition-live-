package Cards;

import Owners.Owner;

/**
 *
 */
public abstract class Tradable {
	public abstract boolean canBeTraded();

	public abstract Owner getOwner();
}
