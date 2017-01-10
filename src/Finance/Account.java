package Finance;

public class Account {
    protected int balance;

    public Account(int value){
        this.balance = value;
    }

    public int getBalance(){
        return balance;
    }

    public void transferTo(Account transferee, int payment){
        transferee.deposit(this.withdraw(payment));
    }

    public void deposit(int value){
	    this.balance += value;
    }

    public boolean payTo(Account transferee, int value){
    	if(this.balance >= value){
		    transferTo(transferee, value);
		    return true;
	    }
	    return false;
    }

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
     * @param value to withdraw.
     * @return amount withdrawn.
     */
    public int withdraw(int value){
        if (value > this.balance){
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
