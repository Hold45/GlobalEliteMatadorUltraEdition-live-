package Cards;

import Board.Fields.Chance;
import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.*;
import Owners.Owner;
import Owners.Player;

import java.util.Collections;
import java.util.LinkedList;

public class CardPile extends Owner {
    private LinkedList<ChanceCard> cards;

    public CardPile(){
        super();
        this.cards = new LinkedList<>();


        this.addTradable(new Gain200(this));
	    this.addTradable(new Gain1000(this, "Card3Desc"));
        this.addTradable(new Gain1000(this, "Card3Desc"));
        this.addTradable(new Gain1000(this, "Card2Desc"));
        this.addTradable(new Gain1000(this, "Card2Desc"));
        this.addTradable(new Gain1000(this, "Card35Desc"));
        this.addTradable(new Gain1000(this, "Card8Desc"));
        this.addTradable(new Gain1000(this, "Card6Desc"));
        this.addTradable(new Gain1000(this, "Card5Desc"));
        this.addTradable(new Gain500(this));
        this.addTradable(new Gain500(this));
        this.addTradable(new Gain3000(this));

        this.addTradable(new Gain200FromAll(this));
        this.addTradable(new Gain500FromAll(this, "Card27Desc"));
        this.addTradable(new Gain500FromAll(this, "Card29Desc"));

        this.addTradable(new Pay200(this, "Card14Desc"));
        this.addTradable(new Pay200(this, "Card18Desc"));
        this.addTradable(new Pay200(this, "Card13Desc"));
        this.addTradable(new Pay300(this));
        this.addTradable(new Pay1000(this, "Card12Desc"));
        this.addTradable(new Pay1000(this, "Card19Desc"));
        this.addTradable(new Pay1000(this, "Card15Desc"));
        this.addTradable(new Pay2000(this));
        this.addTradable(new Pay3000(this));
        this.addTradable(new Pay3000(this));

        this.addTradable(new PayForBuildings500(this));
        this.addTradable(new PayForBuildings800(this));

        this.addCard(new MoveBack(this));
        this.addCard(new MoveBack(this));
        this.addCard(new MoveForward(this));
        this.addCard(new MoveToFrederiksbergAlle(this));
        this.addCard(new MoveToGroenningen(this));

        this.addCard(new MoveToRaadhuspladsen(this));
        this.addCard(new MoveToMolsLinien(this));
        this.addCard(new MoveToVimmelskaftet(this));
        this.addCard(new MoveToStrandvejen(this));
        this.addCard(new MoveToStart(this));
        this.addCard(new MoveToStart(this));
        this.addCard (new MoveToShipX2 (this));
        this.addCard (new MoveToShipX2 (this));
        this.addCard(new MoveToShip(this));

        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveBack(this));
        this.addTradable(new MoveForward(this));
        this.addTradable(new MoveToFrederiksbergAlle(this));
        this.addTradable(new MoveToGroenningen(this));

        this.shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
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

}
