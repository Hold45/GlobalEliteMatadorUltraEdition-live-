package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class GetOutOfJailFree extends ChanceCard {
	public GetOutOfJailFree(Owner owner) {
		super(owner, "GetOutOfJailCardDescription");
	}

	@Override
	public void draw(Player player) {
		super.draw(player);
		this.getOwner().transferTradableTo(player, this);
	}

	@Override
	public void play() {
		((Player) this.getOwner()).release();
	}

	@Override
	public boolean canBeTraded() {
		return true;
	}

	@Override
	public boolean canBePlayed() {
		return ((Player) this.getOwner()).isJailed();
	}
}
