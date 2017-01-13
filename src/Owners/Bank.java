package Owners;

import Board.Fields.Properties.Property;
import Buildings.Building;
import Buildings.Hotel;
import Buildings.House;
import Finance.Account;
import Game.Game;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Bank
 * 
 * Bank is the bank of the game and is seperat from player because Bank can not lose.
 * 
 */
public class Bank extends Accountable {
    private ArrayList<Building> buildings;

    /**
	 * Creates a new account with any currency and adds the buildings to the bank
	 * 
	 * @see Account
	 * 
	 */
    public Bank(Game game){
        super(game);
        this.account = new Account(10000);
        this.buildings = new ArrayList<>();
        for (int i=0; i<22; i++){
            this.buildings.add(new House());
            this.buildings.add(new Hotel());
        }

    }
    
    /**
	 * @return list of buildings
	 */
	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}
	
	/**
	 * This can move a building of a type, from one owner to another 
	 * 
	 * @param from the owner
	 * @param to the owner
	 * @param c type of building to move
	 * @return true if building gets moved 
	 */
	private boolean moveBuilding(ArrayList<Building> from, ArrayList<Building> to, Class c){
		for (int i = 0; i < from.size(); i++) {
			if(from.get(i).getClass().isAssignableFrom(c)){
				to.add(from.remove(i));
				return true;
			}
		}
		return false;
	}
	/**
	 * Give buildings matching a collection of types to an property
	 * 
	 * @param classes which collection of buildings
	 * @param property which property to give
	 * 
	 */
	public void giveBuildings(Property property, Collection<Class> classes){
		for (Class c : classes) {
			this.moveBuilding(property.getBuildings(), this.buildings, c);
		}
	}
	/**
	 * This can take buildings of a certain type from an owner
	 * 
	 * @param property which property to take
	 * @param classes which class of building
	 * 
	 */

	public void takeBuildings(Property property, Collection<Class> classes){
		for (Class c: classes) {
			this.moveBuilding(this.buildings, property.getBuildings(), c);
		}
	}
	

	public Account getAccount() {
        return this.account;
    }
}
