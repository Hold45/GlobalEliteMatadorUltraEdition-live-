package Game;

import Board.Board;
import Cards.CardPile;
import Dice.MonopolyCup;
import GUI.MonopolyGUI;
import Game.Turns.Turn;
import Owners.Bank;
import Owners.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 *
 */
public class Game {
	private ArrayList<Player> players;
	private ArrayList<Player> losers;
	private Stack<Turn> turns;
	private Bank bank;
	private MonopolyGUI gui;
	private Board board;
	private CardPile cardPile;
	private MonopolyCup cup;
	private ArrayList<Turn> turnLog;
	private Random random;

	public Game(MonopolyGUI gui, Random rng){
		this.players = new ArrayList<>();
		this.losers = new ArrayList<>();
		this.turns = new Stack<>();
		this.bank = new Bank(this);
		this.gui = gui;
		this.board = new Board(this);
		this.random = rng;
		this.cardPile = new CardPile(this, this.random);
		this.cup = new MonopolyCup(this.random);
		this.turnLog = new ArrayList<>();
		this.cardPile.shuffle();
	}

	public Game(MonopolyGUI gui) {
		this(gui, new Random());
	}

	public void start(){
		assert !players.isEmpty();

		Collections.shuffle(players, this.random);
		this.turns.push(players.get(0).getTurn());

		while (!this.turns.isEmpty() && !this.hasWinner()){
			this.turns.pop().take();
		}
	}

	public Player nextPlayer(Player player){
		return this.players.get(Math.floorMod(this.players.indexOf(player)+1, this.players.size()));
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

	/**
	 * @param firstPlayer the player to start from
	 * @return a copy of players, rotated so the given player is first
	 */
	public ArrayList<Player> getPlayers(Player firstPlayer){
		ArrayList<Player> playersCopy = new ArrayList<>(this.getPlayers());
		Collections.rotate(playersCopy, -this.getPlayers().indexOf(firstPlayer));
		return playersCopy;
	}

	/**
	 * @param excluded player to exclude
	 * @return all players except the given player
	 */
	public ArrayList<Player> getOtherPlayers(Player excluded) {
		return this.getPlayers().stream().filter(other -> !excluded.equals(other)).collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @param excluded player to exclude
	 * @param firstPlayer the player to start from
	 * @return all players except the excluded player, rotated so the given player is first
	 */
	public ArrayList<Player> getOtherPlayers(Player excluded, Player firstPlayer) {
		ArrayList<Player> playersCopy = new ArrayList<>(this.getOtherPlayers(excluded));
		Collections.rotate(playersCopy, -this.getPlayers().indexOf(firstPlayer));
		return playersCopy;
	}

	public ArrayList<Player> getLosers() {
		return this.losers;
	}

	public MonopolyGUI getGUI() {
		return this.gui;
	}

	public MonopolyCup getCup() {
		return this.cup;
	}

	public Board getBoard() {
		return this.board;
	}

	public CardPile getCardPile() {
		return this.cardPile;
	}

	public ArrayList<Turn> getTurnLog() {
		return this.turnLog;
	}

	public boolean hasWinner(){
		return this.getPlayers().size() == 1;
	}

}
