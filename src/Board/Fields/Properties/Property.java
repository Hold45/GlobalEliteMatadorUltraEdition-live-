package Board.Fields.Properties;

import Board.Fields.Field;
import Board.Fields.Properties.Deeds.Deed;
import Buildings.Building;
import Game.Game;
import Owners.Accountable;
import Owners.Player;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Property extends Field {

	protected Deed deed;
	protected ArrayList<Building> buildings;
	protected Class[][] upgradeSignature;

	public Property(Game game, String name, String description, int price) {
		super(game, name, description);
		this.deed = new Deed(this, price, game.getBank());
		this.buildings = new ArrayList<>();
	}

	@Override
	public void onLand(Player player) {
		super.onLand(player);

		if (
			this.getDeed().isPlayerOwned()
			&& !this.getDeed().isPawned()
			&& !(((Player)this.getDeed().getOwner()).isJailed())
			&& this.getDeed().getOwner() != player
		){
			player.getAccount().transferTo(((Accountable)this.getDeed().getOwner()).getAccount(), this.getRent());
		}
		else if(!this.getDeed().isPlayerOwned()){
			if(player.getGame().getGUI().acceptBuyProperty(player, "BuyProperty??", this.getDeed(), this.getDeed().getPrice())){
				this.getDeed().tryPurchase(player);
			}
			//TODO: add auction.
		}
	}

	public Stream<Property> getSameColorProperties() {
		return Arrays.stream(this.getGame().getBoard().getFields())
				.filter(field -> field.getClass().getSuperclass() == this.getClass().getSuperclass())
					.map(field -> (Property) field);
	}

	public abstract int getRent();

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	public Deed getDeed() {
		return this.deed;
	}

	public int getUpgradeValue() {
		for (int i = this.upgradeSignature.length-1; i >= 0 ; i--) {
			if(CollectionUtils.isSubCollection(Arrays.asList(this.upgradeSignature[i]), Arrays.asList(this.buildings.stream().map(Building::getClass).toArray(Class[]::new)))){
				return i;
			}
		}
		return 0;
	}

	public boolean canBeUpgraded(){
		return
				this.getUpgradeValue() < this.upgradeSignature.length
				&& !this.getDeed().isPawned()
				&& this.getSameColorProperties()
						.noneMatch(property -> property.getUpgradeValue() < this.getUpgradeValue())
				&& this.getSameColorProperties()
						.allMatch(property -> property.getDeed().getOwner().equals(this.getDeed().getOwner()));
	}

	public boolean canBeDowngraded(){
		return
				getUpgradeValue() > 0
				&& this.getSameColorProperties()
						.noneMatch(property -> property.getUpgradeValue() > this.getUpgradeValue());
	}

	public boolean tryUpgrade(){
		if(
			canBeUpgraded()
			&& CollectionUtils.isSubCollection(
				this.requiredBuildingsForUpgrade(),
				this.getGame().getBank().getBuildings().stream()
						.map(Building::getClass)
							.collect(Collectors.toList())
			)
			&& ((Accountable)this.getDeed().getOwner()).getAccount().payTo(
				this.getGame().getBank().getAccount(),
				this.getDeed().getUpgradePrice()
			)
		){
			upgrade();
			return true;
		}
		return false;
	}

	public void upgrade() {
		this.getGame().getBank().giveBuildings(this, this.obsoleteBuildingsForUpgrade());
		this.getGame().getBank().takeBuildings(this, this.requiredBuildingsForUpgrade());
	}

	public boolean tryDowngrade(){
		if(!canBeDowngraded()){
			return false;
		}
		downgrade();
		return true;
	}

	public void downgrade() {
		this.getGame().getBank().getAccount().transferTo(((Accountable)this.getDeed().getOwner()).getAccount(), this.getDeed().getUpgradePrice()/2);
		this.getGame().getBank().giveBuildings(this, this.obsoleteBuildingsForDowngrade());
	}

	/**
	 * Returns an Collection with buildings which are obsolete for the upgrade.
	 *
	 * @return Buildings to remove when upgrading
	 */
	private Collection<Class> obsoleteBuildingsForUpgrade() {
		return buildingsSignatureChange(0,1);
	}

	private Collection<Class> buildingsSignatureChange(int indexFrom, int indexTo){
		return CollectionUtils.subtract(
				Arrays.asList(this.upgradeSignature[getUpgradeValue()+indexFrom]),
				Arrays.asList(this.upgradeSignature[getUpgradeValue()+indexTo])
		);
	}

	/**
	 * Returns an Collection with buildings needed for the next upgrade.
	 *
	 * @return Buildings need for upgrading
	 */
	private Collection<Class> requiredBuildingsForUpgrade() {
		return buildingsSignatureChange(1,0);
	}

	private Collection<Class> obsoleteBuildingsForDowngrade(){
		if(this.getUpgradeValue() < 0)
			return buildingsSignatureChange(0,-1);
		return new ArrayList<>();
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

