package Cards;

import Cards.ChanceCards.ChanceCard;
import Cards.ChanceCards.TryYourLuck.GainMoney;

import java.util.Collections;
import java.util.LinkedList;

public class CardPile {
    private LinkedList<ChanceCard> cards;

    public CardPile(){
        this.cards = new LinkedList<>();
        for (int i=0; i<10; i++){
            this.cards.add(new GainMoney("Du er heldig"+i,1000*i));
        }
        this.shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public ChanceCard drawCard(){
        return this.cards.poll();
    }

    public void addCard(ChanceCard card){
        this.cards.add(card);
    }

}
