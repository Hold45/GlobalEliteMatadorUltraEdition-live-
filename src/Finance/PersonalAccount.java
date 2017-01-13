package Finance;

import Game.Actions.DowngradeProperty;
import Game.Actions.PawnDeed;
import Game.Actions.SellDeedToBank;
import Owners.Player;

public class PersonalAccount extends Account {

    private Player owner;

    public PersonalAccount(Player player, int value){
        super(value);
        this.owner = player;
    }

    @Override
    public int withdraw(int value){
    	while (value > this.balance && PawnDeed.self.runnable(this.owner) && DowngradeProperty.self.runnable(this.owner) && SellDeedToBank.self.runnable(this.owner)){
		    this.owner.takeActions(PawnDeed.self, DowngradeProperty.self, SellDeedToBank.self);
	    }

        if (value > this.balance){
            int beforeWithdraw = this.getBalance();
            this.owner.getGame().addLoser(this.owner);
            this.balance = 0;
            return beforeWithdraw;
        }
        else {
            this.balance -= value;
            return value;
        }
    }

}
