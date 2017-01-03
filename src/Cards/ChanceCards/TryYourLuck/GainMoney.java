package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Player.Player;

public class GainMoney extends ChanceCard {
    private int amount;

    public GainMoney(String description, int amount) {
        super(description);
        this.amount = amount;
    }

    @Override
    public void resolve(Player player) {
        player.getAccount().deposit(this.amount);
    }
}
