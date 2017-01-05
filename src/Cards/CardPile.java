package Cards;

import Cards.ChanceCards.ChanceCard;
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
        for (int i=0; i<10; i++){
            this.cards.add(new GainMoney(this,"Du er heldig"+i,1000*i));
        }
        this.shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public ChanceCard drawCard(Player drawer){
        return this.cards.poll();
    }

    public void addCard(ChanceCard card){
        this.cards.add(card);
    }

	@Override
	public void addTradable(Tradable tradable) {
		this.addCard((ChanceCard) tradable);
	}
}
