package Cards.ChanceCards;

import Owners.Player;

public abstract class ChanceCard {
    protected String description;

    public ChanceCard(String description){
        this.description = description;
    }

    public void resolve(Player player){

    }

    public String getDescription() {
        return this.description;
    }
}
