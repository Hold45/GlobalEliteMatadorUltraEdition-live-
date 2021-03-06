package Game.Turns;

import Game.Actions.*;
import Owners.Player;

public class RegularTurn extends Turn {
	/**
	 * the person who is doing this turn.
	 * @param owner that is taking the turn.
	 */
	public RegularTurn(Player owner){
		super(owner);
	}
	
	/**
	 * Gives the player options to do on their turn. It also calls the rollAndMove
	 * @see Player#rollAndMove()
	 */
	public void take(){
		super.take();
		this.getOwner().takeActions(
				PlayCard.self,
				Bail.self,
				PawnDeed.self,
				DowngradeProperty.self,
				SellDeedToBank.self,
				UnpawnDeed.self,
				UpgradeProperty.self,
				ProposeTrade.self
		);
		this.owner.rollAndMove();

	}
}
