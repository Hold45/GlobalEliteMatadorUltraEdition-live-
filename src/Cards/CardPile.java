package Cards;

import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.Gain1000;
import Cards.ChanceCards.TryYourLuck.Gain200;
import Cards.ChanceCards.TryYourLuck.GainMoney;
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
	    this.addCard(new Gain1000(this, "Card1Desc"));

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
