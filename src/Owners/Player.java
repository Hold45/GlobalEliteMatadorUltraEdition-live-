package Owners;

import Board.Fields.Field;
import Board.Fields.LawInforcment.Jail;
import Board.Fields.Properties.Deeds.Deed;
import Cards.Tradable;
import Finance.Account;
import Finance.PersonalAccount;
import Game.Actions.Action;
import Game.Actions.EndActions;
import Game.Game;
import Game.Turns.RegularTurn;
import Game.Turns.ScheduledTurn;
import Game.Turns.Turn;

import java.util.ArrayList;
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
    private ScheduledTurn turn;
    private RegularTurn additionalTurn;
    private int position;
    private boolean jailed;
    private Turn mrMonopolyTurn;
    private String name;
	/**
	 * @param game which game is being played
	 * 
	 */
    public Player(Game game) {
        super(game);
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

    public Player(Game game, String name){
    	this(game);
    	this.name = name;
	}

    public Account getAccount() {
		return this.account;
    }

	public RegularTurn getTurn() {
		return this.turn;
	}

	/**
	 * Lets the player perform the given actions, for as long as they are available, in any order.
	 *
	 * @param actions that the player can take
	 * @see Action
	 */
	public void takeActions(Action... actions){
		Action chosenAction;
		do {
		    Action[] options =
				Arrays.stream(actions)
					.filter(action -> action.runnable(this) && !this.getGame().hasWinner())
						.toArray(Action[]::new);
		    options = Arrays.copyOf(options, options.length+1);
		    options[options.length-1] = options[0];
		    options[0] = EndActions.self;
			chosenAction = this.game.getGUI().chooseAction(this, "ChooseAction", options);
		    chosenAction.run(this);
		}
    	while (!(chosenAction instanceof EndActions));
	}
	
	/**
	 * Moves the player a given amount forward.
	 *
	 * All fields in between, including the one the player starts on, will be moved over.
	 * Unless the player is moving backwards.
	 * Calls onLand for the final field.
	 *
	 * @param offSet how many fields to move forward
	 * @return the current player
	 */
	public Player move(int offSet){
		for(int i = 0; i < offSet; i++)
			this.getGame().getBoard().getField(this.getOffsetPosition(i)).onMoveOver(this);
		this.position = getOffsetPosition(offSet);
		this.game.getBoard().getFields()[this.getPosition()].onLand(this);
	    return this;
	}

	/**
	 * Move to a specific field in positiv direction.
	 *
	 * @param field to move to
	 * @return current player
	 */
	public Player moveTo(Field field){
		return moveTo(this.getGame().getBoard().getIndex(field));
	}

	/**
	 * Move to the first field of a given type in positiv direction.
	 *
	 * @param c which type to move to
	 * @return current player
	 */
	public Player moveTo(Class c){
		return moveTo(this.getGame().getBoard().getIndex(c, this));
	}

	/**
	 * Move to the field with the given index in positiv direction.
	 *
	 * @param moveToPos is a position of a field the players has to move to
	 * @return current player 
	 */
	private Player moveTo(int moveToPos){
		if(this.position < moveToPos)
			return move(moveToPos-this.position);
		return move(this.getGame().getBoard().getFields().length - this.position + moveToPos);
	}

	/**
	 * This modulus calculation is used to find out where we have to be on the board exactly 
	 *
	 * @param addToPos is the number to ad to the current position.
	 * @return returns the exact position the player needs to move to. 
	 */
	int getOffsetPosition(int addToPos) {
		return Math.floorMod((this.position+addToPos), this.game.getBoard().getFields().length);
	}

	/**
	 * This method is used to play out a turn for the player. It calls the DiceCup and makes a roll. It also checks whether or not the player is in prison
	 * if the player is in prison it goes through a for loop that checks whether or not the player has had yahtzee for the player to be released.
	 *
	 * @return current player
	 */
	public Player rollAndMove(){
		this.getGame().getCup().roll();

		if (this.getGame().getCup().triple() && !this.isJailed()){
			this.moveTo(this.getGame().getGUI().chooseField(this, "ChooseFieldMoveTo", this.getGame().getBoard().getFields()));
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
		if (!this.isJailed() && !this.getGame().getCup().triple()) {
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

	/**
	 * This gives the player the option of choosing a field to move to when the player can move with the bus. 
	 */
	private void moveWithBus() {
		this.moveTo(this.getGame().getGUI().chooseField(
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

	/**
	 * Checks if the player can be bailed.
	 *
	 * This include checking if the player is jailed and has enough money.
	 *
	 * @return true if bailable
	 */
	public boolean isBailable(){
		return this.isJailed() && this.getAccount().getBalance() >= 1000;
	}

	/**
	 * Checks if the player is bailable, and bails the player.
	 *
	 * @return true if bailed
	 */
	public boolean tryBail(){
		if (!this.isBailable())
			return false;
		this.getAccount().payTo(this.getGame().getBank().getAccount(), 1000);
		this.release();
		return true;
	}

	/**
	 * Set the jailed value to true and move the player to the nearest jail space.
	 */
	public void arrest(){
		this.moveTo(Jail.class);
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

	public void lose(){
		this.getGame().addLoser(this);
		this.getAccount().transferTo(this.getGame().getBank().getAccount(), this.getAccount().getBalance());
		for (Tradable tradable: new ArrayList<>(this.getOwns())) {
			this.transferTradableTo(this.getGame().getBank(), tradable);
			tradable.auctionOff(100, 100);
		}
		this.getGame().getGUI().addMessage(this, "PlayerLose");
	}

	/**
	 * @return the total value of all the players deeds and money
	 */
	public int getTotalCaptialValue(){
		return
			this.getOwns().stream()
				.filter(tradable -> tradable instanceof Deed)
					.mapToInt(deed -> ((Deed)deed).totalValue())
						.sum()
			+ this.getAccount().getBalance();
	}
}

