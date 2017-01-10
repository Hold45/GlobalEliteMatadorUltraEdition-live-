package Game.Actions;
import Owners.Player;

/**
 *
 */
public abstract class Action{
	public abstract void run(Player player);

	public abstract boolean runnable(Player player);

	protected Player chooseOtherPlayer(Player player){
		return chooseOtherPlayer(player, "ChooseSellToPlayer");
	}

	protected Player chooseOtherPlayer(Player player, String string){
		return player.getGame().getGUI().choosePlayer(
				player,
				string,
				player.getGame().getPlayers().stream().
						filter(other -> other != player).
						toArray(Player[]::new));
	}

}
