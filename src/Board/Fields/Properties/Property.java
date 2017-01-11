package Board.Fields.Properties;

import Board.Fields.Field;
import Board.Fields.Properties.Deeds.Deed;
import Buildings.Building;
import Game.Game;
import Owners.Accountable;
import Owners.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public abstract class Property extends Field {

	protected Deed deed;
	protected ArrayList<Building> buildings;

	public Property(Game game, String name, String description, int price) {
		super(game, name, description);
		this.deed = new Deed(this, price, game.getBank());
		this.buildings = new ArrayList<>();
	}


	@Override
	public void onLand(Player player) {
		super.onLand(player);

		if(this.getDeed().isOwned() && !this.getDeed().isPawned() && !(((Player)this.getDeed().getOwner()).isJailed()) && this.getDeed().getOwner() != player){
			player.getAccount().transferTo(((Accountable)this.getDeed().getOwner()).getAccount(), this.getRent());
		}
		else if(!this.getDeed().isOwned()){
			if(player.getGame().getGUI().acceptBuyProperty(player, "BuyProperty??", this.getDeed(), this.getDeed().getPrice())){
				this.getDeed().tryPurchase(player);
			}
			//TODO: add auction.
		}
	}

	public abstract int getRent();

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	public Deed getDeed() {
		return this.deed;
	}

	public Stream<Field> getFriends(){
		return Arrays.stream(this.getGame().getBoard().getFields())
				.filter(field -> field.getClass().getSuperclass().isAssignableFrom(this.getClass().getSuperclass()));
	}

	public Stream<Field> getOwnedFriends(){
		return this.getFriends()
			.filter(field -> ((Property)field).getDeed().getOwner() == this.getDeed().getOwner());
	}
}

