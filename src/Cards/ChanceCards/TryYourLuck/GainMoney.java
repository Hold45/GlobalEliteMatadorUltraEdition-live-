package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class GainMoney extends ChanceCard {
    private int amount;

    public GainMoney(Owner owner, String description, int amount) {
        super(owner, description);
        this.amount = amount;
    }

    @Override
    public void draw(Player player) {
        super.draw(player);
        player.getAccount().deposit(this.amount);
    }
}
