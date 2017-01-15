package Cards.ChanceCards.TryYourLuck;

import Cards.ChanceCards.ChanceCard;
import Owners.Owner;
import Owners.Player;

public class GetOutOfJailFree extends ChanceCard {
	public GetOutOfJailFree(Owner owner) {
		super(owner, "GetOutOfJailCardDescription");
	}

	/**
	 * The player who draws the card, gets the card as one of the tradables they own.
	 *
	 * @param player who draws
	 */
	@Override
	public void draw(Player player) {
		super.draw(player);
		this.getOwner().transferTradableTo(player, this);
	}

	/**
	 * Releases the player from jail.
	 */
	@Override
	public void play() {
		if(this.isPlayerOwned())
			((Player) this.getOwner()).release();
		super.play();
	}


	/**
	 * Always return true as this card is always tradable.
	 *
	 * @return true as tradable
	 */
	@Override
	public boolean canBeTraded() {
		return true;
	}


	/**
	 * Checks if the card can be played.
	 *
	 * @return true if playable
	 */
	@Override
	public boolean canBePlayed() {
		return this.isPlayerOwned() && ((Player) this.getOwner()).isJailed();
	}
}
