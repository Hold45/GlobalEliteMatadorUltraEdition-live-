package Owners;

import Board.Fields.Ownables.Deeds.Deed;
import Board.Fields.Ownables.Ownable;
import Finance.Account;

import java.util.ArrayList;

/**
 *
 */
public abstract class Owner {
	protected ArrayList<Deed> owns;
	protected Account account;

	public Owner(){
		this.owns = new ArrayList<>();
	}

	public Account getAccount() {
		return this.account;
	}

	public void addDeed(Deed deed){
		this.owns.add(deed);
	}

	public boolean removeDeed(Deed deed){
		return this.owns.remove(deed);
	}
	public void transferDeedTo(Owner to, Deed deed){
		if(this.removeDeed(deed))
			to.addDeed(deed);
	}

}

