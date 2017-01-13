package Owners;

import Finance.Account;
import Game.Game;

/**
 *
 */
public abstract class Accountable extends Owner {
	protected Account account;

	public Accountable(Game game) {
		super(game);
	}

	public Account getAccount() {
		return this.account;
	}
}
