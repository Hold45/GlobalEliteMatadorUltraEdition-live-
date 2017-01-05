package Owners;

import Finance.Account;

/**
 *
 */
public abstract class Accountable extends Owner {
	protected Account account;

	public Account getAccount() {
		return this.account;
	}
}
