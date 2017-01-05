package Finance;

import Game.Actions.ProposeTrade;
import Owners.Player;

public class PersonalAccount extends Account {

    private Player owner;

    public PersonalAccount(Player player, int value){
        super(value);
        this.owner = player;
    }

    @Override
    public int withdraw(int value){
    	this.owner.takeActions(ProposeTrade.self);

        if (value>this.balance){
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
