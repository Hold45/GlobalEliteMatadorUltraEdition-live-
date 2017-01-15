package Cards;

import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.*;
import Game.Game;
import Owners.Owner;
import Owners.Player;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CardPile extends Owner {
    private LinkedList<ChanceCard> cards;
    private Random random;

    public CardPile(Game game, Random random){
        super(game);
        this.cards = new LinkedList<>();
        this.random = random;

        this.addTradable(new Gain200(this));
	    this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain1000(this));
        this.addTradable(new Gain500(this));
        this.addTradable(new Gain500(this));
        this.addTradable(new Gain3000(this));

        this.addTradable(new Gain200FromAll(this));
        this.addTradable(new Gain500FromAll(this));
        this.addTradable(new Gain500FromAll(this));

        this.addTradable(new Pay200(this));
        this.addTradable(new Pay200(this));
        this.addTradable(new Pay200(this));
        this.addTradable(new Pay300(this));
        this.addTradable(new Pay1000(this));
        this.addTradable(new Pay1000(this));
        this.addTradable(new Pay1000(this));
        this.addTradable(new Pay2000(this));
        this.addTradable(new Pay3000(this));
        this.addTradable(new Pay3000(this));

        this.addTradable(new PayForBuildings500(this));
        this.addTradable(new PayForBuildings800(this));

        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveForward(this));
        this.addTradable(new MoveToFrederiksbergAlle(this));
        this.addTradable(new MoveToGroenningen(this));

        this.addTradable(new MoveToRaadhuspladsen(this));
        this.addTradable(new MoveToMolsLinien(this));
        this.addTradable(new MoveToVimmelskaftet(this));
        this.addTradable(new MoveToStrandvejen(this));
        this.addTradable(new MoveToStart(this));
        this.addTradable(new MoveToStart(this));
        this.addTradable (new MoveToShipX2 (this));
        this.addTradable (new MoveToShipX2 (this));
        this.addTradable(new MoveToShip(this));

        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveForward(this));
        this.addTradable(new MoveToFrederiksbergAlle(this));
        this.addTradable(new MoveToGroenningen(this));

        this.addTradable(new GetOutOfJailFree(this));
        this.addTradable(new GetOutOfJailFree(this));
    }

    public void shuffle(){
	    Collections.shuffle(this.cards, random);
    }

    public void drawCard(Player drawer){
        ChanceCard card = this.cards.poll();
        card.draw(drawer);
	    if (this.isOwnerOf(card))
            this.addTradable(card);
    }

	public void addTradable(ChanceCard card) {
    	super.addTradable(card);
		this.cards.add(card);
	}

	@Override
	public boolean removeTradable(Tradable card){
        this.cards.remove(card);
        return super.removeTradable(card);
    }

	public LinkedList<ChanceCard> getCards() {
		return this.cards;
	}
}
