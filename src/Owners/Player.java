package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Property;
import Finance.Account;
import Finance.PersonalAccount;
import Game.*;
import Game.Actions.*;
import Game.Turns.RegularTurn;
import Game.Turns.ScheduledTurn;
import Game.Turns.Turn;
import java.util.Arrays;

/**
 * Player
 *
 * Player is the main account for the accountables that will be controlled by a player
 * This is used to move around the board, check if the player is in prison, iniziate die throws, and to see where the player is located.
 * Player is needed to be an Accountable due to it having to store which buildings it owns while still being an account to pa
 *
 * @see Game
 * @see ScheduledTurn
 * @see RegularTurn
 * @see Accountable
 * @see Turn
 */
public class Player extends Accountable{
    private Game game;
    private ScheduledTurn turn;
    private RegularTurn additionalTurn;
    private int position;
    private boolean jailed;
    private Turn mrMonopolyTurn;
    private String name;
	/**
	 * 
	 * @param game which game it is ½
	 * 
	 */
    public Player(Game game) {
        super();
        this.position = 0;
        this.game = game;
        this.account = new PersonalAccount(this,30000);
        this.turn = new ScheduledTurn(this);
        this.additionalTurn = new RegularTurn(this);
        this.jailed = false;
        this.name = "name";
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
		    Action[] options = Arrays.stream(actions).filter(action -> action.runnable(this) && !this.getGame().hasWinner()).toArray(Action[]::new);
		    options = Arrays.copyOf(options, options.length+1);
		    options[options.length-1] = EndActions.self;
			chosenAction = this.game.getGUI().chooseAction(this, "ChooseAction", options);
		    chosenAction.run(this);
		}
    	while (!(chosenAction instanceof EndActions));
	}

	public Player move(int addToPos){
		for(int i = 0; i < addToPos; i++)
			this.getGame().getBoard().getField(this.getOffsetPosition(i)).onMoveOver(this);
		this.position = getOffsetPosition(addToPos);
		this.game.getBoard().getFields()[this.position].onLand(this);
	    return this;
	}

	public Player move(Field field){
		return moveTo(this.getGame().getBoard().getIndex(field, this));
	}

	public Player move(Class c){
		return moveTo(this.getGame().getBoard().getIndex(c, this));
	}

	private Player moveTo(int moveToPos){
		if(this.position <= moveToPos)
			return move(moveToPos-this.position);
		return move(this.getGame().getBoard().getFields().length - (this.position - moveToPos));
	}

	int getOffsetPosition(int addToPos) {
		return Math.floorMod((this.position+addToPos), this.game.getBoard().getFields().length);
	}

	public Player rollAndMove(){
		this.getGame().getCup().roll();

		if (this.getGame().getCup().triple() && !this.isJailed()){
			this.move(this.getGame().getGUI().chooseField(this, "ChooseFieldMoveTo", this.getGame().getBoard().getFields()));
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
					this.move(this.getGame().getCup().getSum());
					break;
				case 6:
					moveWithBus();
					break;
			}
		}

		return this;
	}

	private void moveWithBus() {
		this.move(this.getGame().getGUI().chooseField(
				this,
				"ChooseBusFieldMoveTo",
				Arrays.stream(this.getGame().getCup().getCombinations())
					.map(this::getOffsetPosition)
						.mapToObj(this.getGame().getBoard()::getField)
							.toArray(Field[]::new)));
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}

