package Finance;

public class Account {
    protected int balance;

    public Account(int value){
        this.balance = value;
    }

    public int getBalance(){
        return balance;
    }

    public void transferTo(Account transferTo, int payment){
        transferTo.deposit(this.withdraw(payment));
    }

    public void deposit(int value){
        this.balance += value;
    }

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
     * @param value to withdraw.
     * @return amount withdrawn.
     */
    public int withdraw(int value){
        if (value>this.balance){
            int beforeWithdraw = this.balance;
            this.balance = 0;
            return beforeWithdraw;
        }
        else {
            this.balance -= value;
            return value;
        }
    }
}
