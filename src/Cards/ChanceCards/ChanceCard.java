package Cards.ChanceCards;

import Cards.Tradable;
import Owners.Owner;
import Owners.Player;

public abstract class ChanceCard extends Tradable{
    protected String description;

    public ChanceCard(Owner owner, String description){
	    super(owner);
	    this.description = description;
    }

    public void draw(Player player){

    }

	@Override
	public boolean canBeTraded() {
		return false;
	}

	public String getDescription() {
        return this.description;
    }
}
