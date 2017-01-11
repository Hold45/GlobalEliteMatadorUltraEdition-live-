package Game.Turns;

import Game.Actions.*;
import Owners.Player;

public class RegularTurn extends Turn {

	public RegularTurn(Player owner){
		super(owner);
	}

	public void take(){
		super.take();
		this.getOwner().takeActions(
				//PawnDeed.self,
				DowngradeProperty.self,
				SellDeedToBank.self,
				UnpawnDeed.self,
				UpgradeProperty.self,
				ProposeTrade.self
		);
		this.owner.rollAndMove();

	}
}
