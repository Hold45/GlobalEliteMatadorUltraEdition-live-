package Owners;

import Board.Fields.Field;
import Finance.Account;
import Finance.PersonalAccount;
import Game.*;
import Game.Actions.*;
import Game.Turns.RegularTurn;
import Game.Turns.ScheduledTurn;
import Game.Turns.Turn;
import java.util.Arrays;

public class Player extends Accountable{
    private Game game;
    private ScheduledTurn turn;
    private RegularTurn additionalTurn;
    private int position;
    private boolean jailed;
    private Turn mrMonopolyTurn;

    public Player(Game game) {
        super();
        this.game = game;
        this.account = new PersonalAccount(this,1000);
        this.turn = new ScheduledTurn(this);
        this.additionalTurn = new RegularTurn(this);
        this.jailed = false;
        this.mrMonopolyTurn = new Turn(this) {
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

	public RegularTurn getTurn() {
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

	public Player move(int addToPos){
		return moveTo(getOffsetPosition(addToPos));
	}

	public Field getNextFieldOfType(Class c) {
		for(int i = 1; i < this.getGame().getBoard().getFields().length; i++){
			if(this.getGame().getBoard().getField(this.getOffsetPosition(i)).getClass().isAssignableFrom(c)){
				return this.getGame().getBoard().getField(this.getOffsetPosition(i));
			}
		}
		return null;
	}

	public int getOffsetPosition(int addToPos) {
		return (this.position+addToPos)%this.game.getBoard().getFields().length;
	}

	public Player moveTo(int moveToPos){
		assert moveToPos <= this.game.getBoard().getFields().length && moveToPos >= 0;

		this.position = moveToPos;
		this.game.getBoard().getFields()[this.position].onLand(this);
		return this;
	}

	public Player moveTo(Class field){
		return this.moveTo(this.game.getBoard().getIndex(field));
	}

	public Player moveTo(Field field){
		return this.moveTo(this.getGame().getBoard().getIndex(field));
	}

	public Player rollAndMove(){
		this.getGame().getCup().roll();

		if (this.getGame().getCup().triple() && !this.isJailed()){
			this.moveTo(this.getGame().getGUI().chooseField(this, "Choose a field", this.getGame().getBoard().getFields()));
		}else {
			if (this.getGame().getCup().yahtzee()) {
				if (this.isJailed()) {
					this.release();
				} else {
					int previousTurns = 0;
					for (int i = this.game.getTurnLog().size() - 1; i >= 0; i--) {
						if (this.game.getTurnLog().get(i) instanceof RegularTurn && this.game.getTurnLog().get(i).getOwner() == this) {
							previousTurns += 1;
							if (previousTurns >= 2) {
								this.arrest();
								break;
							}
						} else if (this.game.getTurnLog().get(i) instanceof RegularTurn && this.game.getTurnLog().get(i).getOwner() != this){
							break;
						}
					}
				}
				this.getGame().getTurns().push(this.additionalTurn);
			}
		}
		if (!this.isJailed()) {
			switch (this.getGame().getCup().getSpeedDie().getValue()) {
				case 1:
				case 2:
				case 3:
					this.move(this.getGame().getCup().getSum());
					break;
				case 4:
				case 5:
					this.getGame().getTurns().push(this.mrMonopolyTurn);
					break;
				case 6:
					this.moveTo(this.getGame().getGUI().chooseField(
							this,
							"whatever",
							Arrays.stream(this.getGame().getCup().getCombinations()).
									 map(this::getOffsetPosition).
										mapToObj(this.getGame().getBoard()::getField).
											toArray(Field[]::new)));
					break;
			}
		}

		return this;
	}

	public int getPosition() {
		return this.position;
	}

	public boolean isJailed() {
		return this.jailed;
	}

	public void arrest(){
		this.jailed = true;
	}

	public void release(){
		this.jailed = false;
	}
}

