package Cards;

import Cards.ChanceCards.ChanceCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CardPileTest {
    private CardPile pile;

    @Before
    public void setup(){
        this.pile = new CardPile();
    }

    @After
    public void tearDown(){
        this.pile = null;
    }

    @Test
    public void drawCard() throws Exception {
        assertThat(this.pile.drawCard()).isInstanceOf(ChanceCard.class);
        assertThat(this.pile.drawCard()).isNull();
    }

}