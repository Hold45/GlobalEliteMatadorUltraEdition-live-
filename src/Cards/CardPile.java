package Cards;

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


        this.addCard(new Gain200(this));
	    this.addCard(new Gain1000(this, "Card3Desc"));
        this.addCard(new Gain1000(this, "Card3Desc"));
        this.addCard(new Gain1000(this, "Card2Desc"));
        this.addCard(new Gain1000(this, "Card2Desc"));
        this.addCard(new Gain1000(this, "Card35Desc"));
        this.addCard(new Gain1000(this, "Card8Desc"));
        this.addCard(new Gain1000(this, "Card6Desc"));
        this.addCard(new Gain1000(this, "Card5Desc"));
        this.addCard(new Gain500(this));
        this.addCard(new Gain500(this));
        this.addCard(new Gain3000(this));

        this.addCard(new Gain200FromAll(this));
        this.addCard(new Gain500FromAll(this, "Card27Desc"));
        this.addCard(new Gain500FromAll(this, "Card29Desc"));

        this.addCard(new Pay200(this, "Card14Desc"));
        this.addCard(new Pay200(this, "Card18Desc"));
        this.addCard(new Pay200(this, "Card13Desc"));
        this.addCard(new Pay300(this));
        this.addCard(new Pay1000(this, "Card12Desc"));
        this.addCard(new Pay1000(this, "Card19Desc"));
        this.addCard(new Pay1000(this, "Card15Desc"));
        this.addCard(new Pay2000(this));
        this.addCard(new Pay3000(this));
        this.addCard(new Pay3000(this));

        this.addCard(new PayForBuildings500(this));
        this.addCard(new PayForBuildings800(this));

        this.addCard(new MoveBack(this));
        this.addCard(new MoveBack(this));
        this.addCard(new MoveForward(this));
        this.addCard(new MoveToFrederiksbergAlle(this));
        this.addCard(new MoveToGroenningen(this));

        this.shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public void drawCard(Player drawer){
        ChanceCard card = this.cards.poll();
        card.draw(drawer);
        if (this.isOwnerOf(card))
            this.addCard(card);
    }

    public void addCard(ChanceCard card){
        this.cards.add(card);
    }

	@Override
	public void addTradable(Tradable tradable) {
    	super.addTradable(tradable);
		this.addCard((ChanceCard) tradable);
	}
}
