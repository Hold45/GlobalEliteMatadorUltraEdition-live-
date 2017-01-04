package Game;

import Owners.Bank;
import Owners.Owner;
import Owners.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


/**
 *
 */
public class Game {
	private ArrayList<Player> players;
	private Stack<Turn> turns;
	private Bank bank;

	public Game() {
		this.players = new ArrayList<>();
		this.turns = new Stack<Turn>();
		this.bank = new Bank();
	}

	public void start(){
		Player player = new Player(this);
		turns.push(player.getTurn());
		addPlayers(player);

		while (!this.turns.isEmpty()){
			this.turns.pop().take();
		}

	}

	public Player nextPlayer(Player player){
		return this.players.get((this.players.indexOf(player)+1)%this.players.size());
	}

	public void addPlayers(Player... players){
		Collections.addAll(this.players, players);
	}

    public void addLoser(Player player) {
    }

	public Bank getBank() {
		return this.bank;
	}

	public Stack<Turn> getTurns() {
		return this.turns;
	}
}
