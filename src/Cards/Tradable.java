package Cards;

import Finance.Account;
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
			purchase(buyer, price);
			return true;
		}
		return false;
	}

	public void purchase(Accountable buyer, int price){
		buyer.getAccount().transferTo(((Accountable)this.owner).getAccount(), price);
		this.setOwner(buyer);
	}

	public void purchase(Accountable buyer){
		purchase(buyer, this.price);
	}

	public boolean tryPurchase(Accountable buyer){
		return tryPurchase(buyer, this.price);
	}


}
