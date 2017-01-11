package Board.Fields.Properties.Plots;

import Game.*;
import org.junit.Test;
import Board.Fields.Properties.Plots.BluePlots.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PlotTest extends SmartTemplateTest {

	@Test
	public void getRent() throws Exception {
		Plot[] plots = Arrays.stream(game.getBoard().getFields())
				.filter(field -> field instanceof BluePlot)
					.toArray(Plot[]::new);


		plots[0].getDeed().setOwner(p1);
		assertThat(plots[0].getRent()).isEqualTo(plots[0].getRentScheme()[0]);

		plots[1].getDeed().setOwner(p1);
		assertThat(plots[1].getRent()).isEqualTo(plots[1].getRentScheme()[0]*2);


	}

}