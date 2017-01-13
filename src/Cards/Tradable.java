package Cards;

import Owners.Accountable;
import Owners.Owner;
import Owners.Player;

import java.util.ArrayList;

/**
 * Tradable
 *
 * This class is used to tell if a class can be traded with other classes.
 * It also adds the basic functionality needed for trading with other classes.
 */
public abstract class Tradable {
	protected Owner owner;
	protected final int price;

	/**
	 *
	 * @param price of the tradable
	 */
	public Tradable(int price) {
		this.price = price;
	}

	/**
	 * Checks whether the tradable can be traded or not.
	 *
	 * @return true if can be traded.
	 */
	public abstract boolean canBeTraded();

	/**
	 * Gets the owner of the tradable.
	 *
	 * @return owner
	 */
	public Owner getOwner(){
		return this.owner;
	}

	/**
	 * Sets the owner of the tradable.
	 *
	 * @param newOwner of the tradable.
	 */
	public void setOwner(Owner newOwner){
		this.owner = newOwner;
	}

	/**
	 * Checks if the tradable can be purchased
	 *
	 * @param buyer purchaser whom which to buy it.
	 * @param price for the tradable.
	 * @return true if purchasable.
	 */
	public boolean isPurchasable(Accountable buyer, int price) {
		return buyer.getAccount().getBalance() > price && !buyer.equals(this.owner);
	}

	/**
	 * Checks if buyer can purchase the deed, and does so if possible.
	 *
	 * @param buyer purchaser whom which to buy it.
	 * @param price the set price of the deed.
	 * @return true if successfully purchased.
	 * @see Tradable#tryPurchase(Accountable)
	 */
	public boolean tryPurchase(Accountable buyer, int price) {
		if(!isPurchasable(buyer, price))
			return false;
		this.purchase(buyer, price);
		return true;
	}

	/**
	 * Checks if buyer can purchase the deed, and does so if possible.
	 *
	 * @param buyer purchaser whom which to buy it.
	 * @return true if successfully purchased.
	 * @see Tradable#tryPurchase(Accountable, int)
	 */
	public boolean tryPurchase(Accountable buyer){
		return tryPurchase(buyer, this.price);
	}


	/**
	 * Purchase the tradable for the given price.
	 * It does not check if it is purchasable.
	 *
	 * @param buyer purchaser of the tradable
	 * @param price price to purchase it for
	 * @see Tradable#tryPurchase(Accountable)
	 * @see Tradable#tryPurchase(Accountable, int)
	 * @see Tradable#isPurchasable(Accountable, int)
	 * @see Tradable#purchase(Accountable)
	 */
	public void purchase(Accountable buyer, int price){
		buyer.getAccount().transferTo(((Accountable)this.owner).getAccount(), price);
		this.owner.transferTradableTo(buyer,this);
	}

	/**
	 * Purchase the tradable for the price of the tradable.
	 *
	 * @param buyer purchaser of the tradable
	 * @see Tradable#price
	 * @see Tradable#purchase(Accountable, int)
	 */
	public void purchase(Accountable buyer){
		purchase(buyer, this.price);
	}

	public void auctionOff(int startPrice, int minimumBidIncrease){
		int price = startPrice;
		ArrayList<Player> participants;
		if (this.owner instanceof Player)
			participants = this.owner.getGame().getOtherPlayers((Player) this.owner);
		else
			participants = new ArrayList<>(this.owner.getGame().getPlayers());
		while (participants.size()>1){
			for (int i = 0; i < participants.size(); i++) {
				if (
					participants.get(i).getAccount().getBalance() >= price+minimumBidIncrease
					&& this.owner.getGame().getGUI().getBooleanFromPlayer(participants.get(i), "ChooseOverbid")){
					price += this.owner.getGame().getGUI().getIntegerFromPlayer((Player) this.owner, "ChooseOverbidValue");
				}else{
					participants.remove(i);
					i--;
				}	
			}
		}
		if(participants.size() == 1)
			this.purchase(participants.get(0), price);
	}
}
