package Owners;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Finance.Account;

import java.util.ArrayList;

/**
 *Owners has an ArrayList that include which tradables is owned by a given player.
 *
 */
public abstract class Owner {
	protected ArrayList<Tradable> owns;

	public Owner(){
		this.owns = new ArrayList<>();
	}
	/**
	 * @return true if owner of 
	 * @param tradable
	 */
	public boolean isOwnerOf(Tradable tradable){
		return this.owns.contains(tradable);
	}
	/**
	 * Adds a tradable to the ArrayList and sets owner to this owner.
	 * @param tradeable to add
	 */
	public void addTradable(Tradable tradable){
		tradable.setOwner(this);
		this.owns.add(tradable);
	}
	
	/**
	 * remove tradable from the arrayList
	 * @param tradable to remove 
	 */
	public boolean removeTradable(Tradable tradable){
		return this.owns.remove(tradable);
	}

	/**
	 * Transfers a tradable from this player to another
	 * 
	 * @param tradable to trade
	 * @param to which player you wish to trade
	 */ 
	public void transferTradableTo(Owner to, Tradable tradable){
		if(this.removeTradable(tradable))
			to.addTradable(tradable);
	}
	/**
	 * @return which tradable this owner owns
	 */
	public ArrayList<Tradable> getOwns() {
		return this.owns;
	}
}

