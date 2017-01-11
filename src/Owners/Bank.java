package Owners;

import Board.Fields.Field;
import Board.Fields.Properties.Property;
import Buildings.Building;
import Buildings.Hotel;
import Buildings.House;
import Finance.Account;
import Owners.Owner;

import java.util.*;

public class Bank extends Accountable {
    private ArrayList<Building> buildings;

    public Bank(){
        super();
        this.account = new Account(10000);
        this.buildings = new ArrayList<>();
        for (int i=0; i<22; i++){
            this.buildings.add(new House());
            this.buildings.add(new Hotel());
        }

    }

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	private boolean moveBuilding(ArrayList<Building> from, ArrayList<Building> to, Class c){
		for (int i = 0; i < from.size(); i++) {
			if(from.get(i).getClass().isAssignableFrom(c)){
				to.add(from.remove(i));
				return true;
			}
		}
		return false;
	}

	public void giveBuildings(Property property, Collection<Class> classes){
		for (Class c : classes) {
			this.moveBuilding(property.getBuildings(), this.buildings, c);
		}
	}


	public void takeBuildings(Property property, Collection<Class> classes){
		for (Class c: classes) {
			this.moveBuilding(this.buildings, property.getBuildings(), c);
		}
	}

	public Account getAccount() {
        return this.account;
    }
}
