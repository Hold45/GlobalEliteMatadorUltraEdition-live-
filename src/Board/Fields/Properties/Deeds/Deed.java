package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Property;
import Cards.Tradable;
import Owners.Accountable;
import Owners.Owner;

/**
 *
 */
public class Deed extends Tradable {
	private final Property field;
	private boolean pawned;

	public Deed(Property field, int price, Accountable owner){
		super(price);
		this.field = field;
		this.owner = owner;
	}

	public int getPrice() {
		return this.price;
	}

	public Property getField() {
		return this.field;
	}

	public boolean isPawned() {
		return this.pawned;
	}

	@Override
	public boolean canBeTraded() {
		return this.field.getBuildings().isEmpty() && !this.isPawned();
	}

}