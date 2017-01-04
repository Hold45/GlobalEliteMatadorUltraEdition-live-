package Game;

import Owners.Player;

public abstract class Turn {
	protected Player owner;

	public Turn(Player owner){
		this.owner = owner;
	}

	public void take(){
		this.owner.getGame().getTurns().push(this.owner.getGame().nextPlayer(this.owner).getTurn());
	}
}
