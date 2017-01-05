package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Property;
import Cards.Tradable;
import Owners.Owner;

/**
 *
 */
public class Deed extends Tradable {
	private final int price;
	private final Property field;

	public Deed(Property field, int price, Owner owner){
		super(owner);
		this.field = field;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public Property getField() {
		return this.field;
	}

	@Override
	public boolean canBeTraded() {
		return this.field.getBuildings().isEmpty() && !this.field.isPawned();
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner newOwner){
		this.owner.transferTradableTo(newOwner,this);
		this.owner = newOwner;
	}

	/**
	 * Checks if buyer can purchase the deed, and does so if possible.
	 *
	 * @param buyer the owner trying to purchase.
	 * @param price the set price of the deed.
	 * @return true if successfully purchased.
	 */
	public boolean tryPurchase(Owner buyer, int price) {
		if(buyer.getAccount().getBalance() < price || buyer.equals(this.owner))
			return false;
		this.owner.getAccount().transferTo(buyer.getAccount(), price);
		this.setOwner(buyer);
		return true;
	}

	public boolean tryPurchase(Owner buyer){
		return tryPurchase(buyer, this.price);
	}
}
