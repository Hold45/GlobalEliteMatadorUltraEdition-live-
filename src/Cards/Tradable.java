package Cards;

import Owners.Accountable;
import Owners.Owner;

/**
 *
 */
public abstract class Tradable {
	protected Owner owner;
	protected final int price;

	public Tradable(int price) {
		this.price = price;
	}

	public abstract boolean canBeTraded();

	public Owner getOwner(){
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
	public boolean tryPurchase(Accountable buyer, int price) {
		if(owner instanceof Accountable){
			if(buyer.getAccount().getBalance() < price || buyer.equals(this.owner))
				return false;
			((Accountable)this.owner).getAccount().transferTo(buyer.getAccount(), price);
			this.setOwner(buyer);
			return true;
		}
		return false;
	}

	public boolean tryPurchase(Accountable buyer){
		return tryPurchase(buyer, this.price);
	}

}
