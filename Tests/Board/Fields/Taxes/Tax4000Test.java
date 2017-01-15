package Board.Fields.Taxes;

import Game.SmartTemplateTest;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class Tax4000Test extends SmartTemplateTest{

	@Test
	public void getRentTest(){
		Tax4000 tax = (Tax4000) game.getBoard().getField(Tax4000.class);
		assertThat(tax.getTax(p1)).isEqualTo(1000);
		p1.getAccount().deposit(100000000);
		assertThat(tax.getTax(p1)).isEqualTo(4000);
	}
}