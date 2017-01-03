package Player;

import Finance.Account;
import Game.Game;

public class Player {
    private Game game;
    private Account account;

    public Player(Game game) {
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
