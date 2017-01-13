package Game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 */
public class SmartRandom extends Random {
	private Queue<Integer> integers;

	public SmartRandom(int... ints) {
		integers = new LinkedList<>();
		add(ints);
	}

	public void add(int... ints){
		for (int i: ints)
			integers.add(i-1);
	}

	@Override
	protected int next(int bits) {
		return integers.poll();
	}

	@Override
	public int nextInt() {
		return integers.poll();
	}

	@Override
	public int nextInt(int bound) {
		return integers.poll();
	}
}
