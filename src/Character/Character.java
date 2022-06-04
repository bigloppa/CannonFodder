package Character;


import Item.*;

import java.lang.Math;
import java.util.ArrayList;


public abstract class Character {
    //FIELDS
    private String name;
    private long hp;
    private int vitality;
    private int strength;
    private int intelligence;
    private Weapon weapon;
    private Clothing clothing;
    private ArrayList<Item> inventory;
    private int state;



    //CONSTRUCTORS + GET-SET
    public Character(){

    }
    public Character(ArrayList<Item> allItems){
        inventory = new ArrayList<Item>();
        state = 2;//ALIVE



    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getHp() {
        return hp;
    }


    public void setHp(long hp) {
        this.hp = hp;
    }


    public int getVitality() {
        return vitality;
    }


    public void setVitality(int vitality) {
        this.vitality = vitality;
    }


    public int getStrength() {
        return strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //METHODS

    public long calculateHp(){
        if (Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength())>35){
            return 35;
        }else{
            return  Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength());
        }
    }



    public boolean pick(Item pickedItem){
        int sum = pickedItem.getWeight();
        for (Item item:getInventory()){
            sum += item.getWeight();

        }

        if (sum<=getVitality()*4){
            inventory.add(pickedItem);
            return true;
        }else{
            System.out.println("The character's weight limit has been reached can't pick up.");
            return false;
        }

    }

    public Item wield(ArrayList<Item> groundInv,String[] userInp){
        for (Item item: groundInv){
            if (item.getName().equals(userInp[2])&& item instanceof Weapon){
                weapon = (Weapon) item;
                return item;
            }
        }

        for (Item item: inventory){
            if (item.getName().equals(userInp[2])&& item instanceof Weapon){
                weapon = (Weapon) item;
                return null;
            }
        }

        return null;



    }

    public Item wear(ArrayList<Item> groundInv,String[] userInput){
        for (Item item: groundInv){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return item;
            }
        }

        for (Item item: inventory){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return null;
            }
        }

        return null;



    }

    /*
    public void examine(String name, ArrayList<Item> ground){
        for (Item item: inventory){
            if (item.getName().equals(name)&& (item instanceof Weapon)){
                System.out.println(item.getName()+" has "+((Weapon) item).getAttackDmg()+" and "+item.getWeight()+" unit of weight.");
            }else if (item.getName().equals(name)&& item instanceof Clothing){
                System.out.println(item.getName()+ " has "+((Clothing) item).getResistance()+" and "+item.getWeight()+" unit of weight.");
            }
        }

        for (Item item: ground){
            if (item.getName().equals(name)&& item instanceof Weapon){
                System.out.println(item.getName()+" has "+((Weapon) item).getAttackDmg()+" and "+item.getWeight()+" unit of weight.");
            }else if (item.getName().equals(name)&& item instanceof Clothing){
                System.out.println(item.getName()+ " has "+((Clothing) item).getResistance()+" and "+item.getWeight()+" unit of weight.");
            }
        }

    }
     */


    public void attack(Character selectedCharacter){
        try {

            int dmg = getWeapon().calculateDmg(this);
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName() + " does " + dmg + " damage. " + selectedCharacter.getName() + " has " + selectedCharacter.getHp() + " HP left.");

        }catch (NullPointerException exception){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");
        }
    }
    public abstract Item createWeapon(ArrayList<Item> allWeapons);




    public void listInventory(){
        System.out.println("Inventory: ");
        for (Item item:getInventory()){
            System.out.println(item.getName());
        }
        System.out.println("********************");
    }






}
