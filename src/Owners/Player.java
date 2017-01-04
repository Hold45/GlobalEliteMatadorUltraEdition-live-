package Owners;

import Finance.Account;
import Owners.Owner;
import Game.Game;

public class Player extends Owner{
    private Game game;

    public Player(Game game) {
        super();
        this.game = game;
        this.account = new Account(1000);
    }

    public Game getGame() {
        return this.game;
    }

    public Account getAccount() {
        return this.account;
    }
}
