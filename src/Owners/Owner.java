package Owners;

import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Finance.Account;

import java.util.ArrayList;

/**
 *
 */
public abstract class Owner {
	protected ArrayList<Tradable> owns;

	public Owner(){
		this.owns = new ArrayList<>();
	}

	public boolean isOwnerOf(Tradable tradable){
		return this.owns.contains(tradable);
	}

	public void addTradable(Tradable tradable){
		tradable.setOwner(this);
		this.owns.add(tradable);
	}

	public boolean removeTradable(Tradable tradable){
		return this.owns.remove(tradable);
	}

	public void transferTradableTo(Owner to, Tradable tradable){
		if(this.removeTradable(tradable))
			to.addTradable(tradable);
	}

	public ArrayList<Tradable> getOwns() {
		return this.owns;
	}
}

