package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Property;
import Cards.Tradable;
import Owners.Accountable;
import Owners.Player;

/**
 *
 */
public class Deed extends Tradable {
	private final Property property;
	private boolean pawned;
	private final int upgradePrice;

	public Deed(Property field, int price, Accountable owner){
		super(price);
		this.property = field;
		this.setOwner(owner);
		owner.addTradable(this);
		this.upgradePrice = 1000;
	}

	public int getPrice() {
		return this.price;
	}

	public Property getProperty() {
		return this.property;
	}

	public int getUpgradePrice() {
		return this.upgradePrice;
	}

	public boolean isPawned() {
		return this.pawned;
	}

	@Override
	public boolean canBeTraded() {
		return
				!this.isPawned()
				&& this.getProperty().getSameColorProperties().allMatch(property -> property.getBuildings().isEmpty());
	}

	public boolean canBePawned(){
		return this.canBeTraded() && this.isPlayerOwned();
	}

	public boolean canBeUnpawned(){
		return this.isPawned() && this.isPlayerOwned() && ((Accountable)this.owner).getAccount().getBalance() >= (int) (this.getPrice()* 0.55);
	}

	public boolean isPlayerOwned(){
		return this.owner instanceof Player;
	}

	public void pawn() {
		((Player)this.owner).getGame().getBank().getAccount().transferTo(
				((Player)this.owner).getAccount(),
				this.getPrice()/2
		);
		this.pawned = true;
	}

	public boolean tryPawn() {
		if(!this.canBePawned())
			return false;
		this.pawn();
		return true;
	}

	public boolean tryUnpawn(){
		if (!this.canBeUnpawned())
			return false;
		this.unPawn();
		return true;
	}

	public void unPawn(){
		((Accountable)this.owner).getAccount().transferTo(
				((Player)this.owner).getGame().getBank().getAccount(),
				(int) (this.getPrice()* 0.55)
		);
		this.pawned = false;
	}
}