package Board.Fields.Ownables.Deeds;

import Board.Fields.Ownables.Ownable;
import Owners.Owner;
import Owners.Player;

/**
 *
 */
public class Deed {
	private final int price;
	private final Ownable field;
	private Owner owner;

	public Deed(Ownable field, int price, Owner owner){
		this.owner = owner;
		this.field = field;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public Ownable getField() {
		return this.field;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner newOwner){
		this.owner.transferDeedTo(newOwner,this);
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
