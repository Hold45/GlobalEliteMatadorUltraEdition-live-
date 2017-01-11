package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Plots.BluePlots.Hvidovrevej;
import Game.DumTemplateTest;
import Game.SmartTemplateTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest extends DumTemplateTest{

	@Test
	public void testStartPosition(){
		assertThat(p1.getPosition()).isEqualTo(0);
	}

	@Test
	public void testMoveToInteger(){
		int pos = game.getBoard().getFields().length-1;
		p1.moveTo(pos);
		assertThat(p1.getPosition()).isEqualTo(pos);
	}

	@Test
	public void testMoveToField(){
		Field field = game.getBoard().getField(Hvidovrevej.class);
		p1.moveTo(field);
		assertThat(p1.getPosition()).isEqualTo(game.getBoard().getIndex(field));
	}

	@Test
	public void testMove(){
		assertThat(p1.move(game.getBoard().getFields().length).getPosition()).isEqualTo(0);

		assertThat(p1.move(game.getBoard().getFields().length).getPosition()).isEqualTo(0);
	}

}