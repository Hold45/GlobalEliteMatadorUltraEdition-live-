package Owners;

import Finance.Account;
import Finance.PersonalAccount;
import Game.*;
import Game.Actions.Action;
import Game.Actions.EndActions;

import java.util.Arrays;

public class Player extends Accountable{
    private Game game;
    private Turn turn;

    public Player(Game game) {
        super();
        this.game = game;
        this.account = new PersonalAccount(this,1000);

        this.turn = new Turn(this) {
	        @Override
	        public void take() {
	        	super.take();
	        }
        };
    }

    public Game getGame() {
        return this.game;
    }

    public Account getAccount() {
        return this.account;
    }

	public Turn getTurn() {
		return this.turn;
	}

	public void takeActions(Action... actions){
		Action chosenAction;
    	do {
		    Action[] options = Arrays.stream(actions).filter(action -> action.runnable(this)).toArray(Action[]::new);
		    options = Arrays.copyOf(options, options.length+1);
		    options[options.length-1] = EndActions.self;

		    chosenAction = this.game.getGUI().chooseAction(this, options);
		    chosenAction.run(this);
	    }
    	while (!(chosenAction instanceof EndActions));
	}

}
