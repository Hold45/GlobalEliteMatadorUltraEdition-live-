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
	protected Account account;

	public Owner(){
		this.owns = new ArrayList<>();
	}

	public Account getAccount() {
		return this.account;
	}

	public void addTradable(Tradable tradable){
		this.owns.add(tradable);
	}

	public boolean removeTradable(Tradable tradable){
		return this.owns.remove(tradable);
	}

	public void transferTradableTo(Owner to, Tradable tradable){
		if(this.removeTradable(tradable))
			to.addTradable(tradable);
	}

}

