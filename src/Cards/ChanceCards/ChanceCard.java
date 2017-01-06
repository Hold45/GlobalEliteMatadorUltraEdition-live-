package Cards.ChanceCards;

import Cards.Tradable;
import Owners.Owner;
import Owners.Player;

public abstract class ChanceCard extends Tradable{
    protected String description;
    private Owner owner;

    public ChanceCard(Owner owner, String description){
    	super(0);
	    this.description = description;
	    this.owner = owner;
    }

    public void draw(Player player){

    }

	@Override
	public Owner getOwner() {
		return this.owner;
	}

	@Override
	public boolean canBeTraded() {
		return false;
	}

	public String getDescription() {
        return this.description;
    }
}
