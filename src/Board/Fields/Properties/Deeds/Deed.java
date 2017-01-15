package Board.Fields.Properties.Deeds;

import Board.Fields.Properties.Property;
import Cards.Tradable;
import Owners.Accountable;
import Owners.Player;


/**
 * Deed
 *
 * A deed is an tradable, which means it can be owned.
 * This is needed as a property cannot be owned, but the deed of the property can be owned.
 *
 * @see Property
 * @see Accountable
 */
public class Deed extends Tradable {
	private final Property property;
	private boolean pawned;
	private final int upgradePrice;

	/**
	 *
	 * @param property of which the deed belongs to
	 * @param price of the deed
	 * @param owner of the deed
	 */
	public Deed(Property property, int price, int upgradePrice, Accountable owner){
		super(price);
		this.property = property;
		this.setOwner(owner);
		owner.addTradable(this);
		this.upgradePrice = upgradePrice;
	}


	public int getPrice() {
		return this.price;
	}

	/**
	 * Gets the property of which the deed belongs to.
	 *
	 * @return property of the deed
	 */
	public Property getProperty() {
		return this.property;
	}


	public int getUpgradePrice() {
		return this.upgradePrice;
	}

	/**
	 * @return true if pawned
	 */
	public boolean isPawned() {
		return this.pawned;
	}

	/**
	 * Checks if the deed can be traded.
	 *
	 * @return true if tradable.
	 */
	@Override
	public boolean canBeTraded() {
		return
				!this.isPawned()
				&& this.getProperty().getSameColorProperties().allMatch(property -> property.getBuildings().isEmpty());
	}

	/**
	 * Checks if the deed can be pawned.
	 *
	 * @return true if pawnable
	 */
	public boolean canBePawned(){
		return this.canBeTraded() && this.isPlayerOwned();
	}

	/**
	 * Checks if the deed can be unpawned.
	 *
	 * @return true if unpawnable
	 */
	public boolean canBeUnpawned(){
		return this.isPawned() && this.isPlayerOwned() && ((Accountable)this.owner).getAccount().getBalance() >= (int) (this.getPrice()* 0.55);
	}

	/**
	 * Pawns a deed
	 *
	 * Pawns a deed and transfer half the cost of the deed to the owner from the bank.
	 * It does not check if it's pawnable.
	 *
	 * @see Deed#canBePawned()
	 * @see Deed#tryPawn()
	 */
	void pawn() {
		((Player)this.owner).getGame().getBank().getAccount().transferTo(
				((Player)this.owner).getAccount(),
				this.getPrice()/2
		);
		this.pawned = true;
	}

	/**
	 * Unpawns a deed
	 *
	 * Unpawns a deed and transfer the money it costs to unpawn it to the bank.
	 * It does not check if it's unpawnable.
	 *
	 * @see Deed#canBeUnpawned()
	 * @see Deed#tryUnpawn()
	 */
	void unPawn(){
		((Accountable)this.owner).getAccount().transferTo(
				((Player)this.owner).getGame().getBank().getAccount(),
				(int) (this.getPrice()* 0.55)
		);
		this.pawned = false;
	}

	/**
	 * Pawns a deed with check
	 *
	 * Checks if the deed can be pawned and if possible then pawn it.
	 *
	 * @return true if pawned successfully
	 * @see Deed#pawn()
	 * @see Deed#canBePawned()
	 */
	public boolean tryPawn() {
		if(!this.canBePawned())
			return false;
		this.pawn();
		return true;
	}

	/**
	 * Unpawns a deed with check
	 *
	 * Checks if the deed can be unpawned and if possible then unpawn it.
	 *
	 * @return true if unpawned successfully
	 * @see Deed#unPawn()
	 * @see Deed#canBeUnpawned()
	 */
	public boolean tryUnpawn(){
		if (!this.canBeUnpawned())
			return false;
		this.unPawn();
		return true;
	}

	@Override
	public String toString(){
		return this.property.getName();
	}

	/**
	 * @return the total value of this, including all buildings on the linked property, and pawn status
	 */
	public int totalValue(){
		if (this.isPawned()){
			return (int) (this.getPrice()*0.15);
		} else {
			return (int) (this.getPrice()*0.7) + this.getProperty().getUpgradeValue()*this.getUpgradePrice();
		}
	}
}