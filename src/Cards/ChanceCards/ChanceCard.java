package Cards.ChanceCards;

import Cards.Tradable;
import Owners.Owner;
import Owners.Player;

public abstract class ChanceCard extends Tradable{
    protected String description;

    public ChanceCard(Owner owner, String description){
    	super(0);
	    this.description = description;
	    this.owner = owner;
    }

    public void draw(Player player){
		player.getGame().getGUI().addMessage(player, this.getDescription());
    }

	@Override
	public Owner getOwner() {
		return this.owner;
	}

	@Override
	public boolean canBeTraded() {
		return false;
	}

	public boolean canBePlayed(){
		return false;
	}

	public void play(){
		this.getOwner().transferTradableTo(this.getOwner().getGame().getCardPile(), this);
	}

	public String getDescription() {
        return this.description;
    }
}
