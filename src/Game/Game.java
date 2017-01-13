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
		this.cardPile = new CardPile(this);
		this.random = rng;
		this.cup = new MonopolyCup(this.random);
		this.turnLog = new ArrayList<>();
	}

	public Game(MonopolyGUI gui) {
		this(gui, new Random());
	}

	public void start(){
		assert !players.isEmpty();

		Collections.shuffle(players);
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

	public ArrayList<Player> getOtherPlayers(Player player) {
		return this.getPlayers().stream().filter(other -> !player.equals(other)).collect(Collectors.toCollection(ArrayList::new));
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
