package Game.Actions;
import Owners.Player;

/**
 *
 */
public interface Action{
	void run(Player player);

	boolean runnable(Player player);
}
