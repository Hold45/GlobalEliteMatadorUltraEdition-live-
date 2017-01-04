package Owners;

import Buildings.Building;
import Buildings.House;
import Finance.Account;
import Owners.Owner;

import java.util.Hashtable;
import java.util.Stack;

public class Bank extends Owner {
    private Hashtable<Class, Stack<Building>> buildings;

    public Bank(){
        super();
        this.account = new Account(10000);
        this.buildings = new Hashtable<>();
        Stack<Building> houses = new Stack<>();
        for (int i=0; i<22; i++){
            houses.push(new House());
        }
        this.buildings.put(House.class, houses);
    }

    /**
     * @param type the desired building type.
     * @return a building of the chosen type if there is any, otherwise returns null.
     */
    public Building takeBuilding(Class type){
        if (!this.buildings.get(type).empty()){
            return this.buildings.get(type).pop();
        }else{
            return null;
        }
    }

    public Account getAccount() {
        return this.account;
    }
}
