package Game;

import GUI.*;
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
	private ArrayList<Player> losers;
	private Stack<Turn> turns;
	private Bank bank;
	private GUI gui;

	public Game(GUI gui) {
		this.players = new ArrayList<>();
		this.losers = new ArrayList<>();
		this.turns = new Stack<Turn>();
		this.bank = new Bank();
		this.gui = gui;
	}

	public void start(){
		Player player = new Player(this);
		Player player2 = new Player(this);
		turns.push(player.getTurn());
		addPlayers(player, player2);

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
		losers.add(player);
		players.remove(player);
    }

	public Bank getBank() {
		return this.bank;
	}

	public Stack<Turn> getTurns() {
		return this.turns;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public ArrayList<Player> getLosers() {
		return this.losers;
	}

	public GUI getGUI() {
		return this.gui;
	}
}
