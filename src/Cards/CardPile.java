package Cards;

import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.GainMoney;
import Finance.Account;
import Owners.Owner;
import Owners.Player;

import java.util.Collections;
import java.util.LinkedList;

public class CardPile extends Owner {
    private LinkedList<ChanceCard> cards;

    public CardPile(){
        super();
        this.cards = new LinkedList<>();
        for (int i=0; i<10; i++){
            this.cards.add(new GainMoney(this,"Du er heldig"+i,1000*i));
        }
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
