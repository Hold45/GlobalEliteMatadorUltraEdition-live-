package Owners;

import Finance.Account;
import Game.Game;
import Game.Turn;

public class Player extends Owner{
    private Game game;
    private Turn turn;

    public Player(Game game) {
        super();
        this.game = game;
        this.account = new Account(1000);

        this.turn = new Turn(this) {
	        @Override
	        public void take() {
	        	super.take();
	        }
        };
    }

    public Game getGame() {
        return this.game;
    }

    public Account getAccount() {
        return this.account;
    }


	public Turn getTurn() {
		return this.turn;
	}
}
