package Character;


import Item.*;
import Main.Level;

import java.lang.Math;
import java.util.ArrayList;


public abstract class Character {
    //FIELDS
    private String name;
    private long hp;
    private int vitality;
    private int strength;
    private int intelligence;
    private IWeaponManager weapon;
    private Clothing clothing;
    private ArrayList<IItemManager> inventory;
    private int state;



    //CONSTRUCTORS + GET-SET
    public Character(){
        inventory = new ArrayList<IItemManager>();
        state = 2;//ALIVE
        clothing = new Clothing(0);

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


    public IWeaponManager getWeapon() {
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

    public ArrayList<IItemManager> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<IItemManager> inventory) {
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



    public boolean pick(IItemManager pickedItem){
        int sum = pickedItem.getWeight();
        for (IItemManager item:getInventory()){
            sum += item.getWeight();

        }

        if (sum<=getVitality()*4){
            inventory.add(pickedItem);
            return true;
        }else{
            System.out.println("The character's weight limit has been reached. "+pickedItem.getName()+ "dropped.");
            return false;
        }

    }

    public void wield(String itemName, Level level){



    }

    public IItemManager wear(ArrayList<IItemManager> groundInv, String[] userInput){
        for (IItemManager item: groundInv){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return item;
            }
        }

        for (IItemManager item: inventory){
            if (item.getName().equals(userInput[2])&& item instanceof Clothing){
                clothing = (Clothing) item;
                return null;
            }
        }

        return null;



    }




    public void attack(Character selectedCharacter){
        try {

            int dmg = getWeapon().calculateDmg(this);
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg + selectedCharacter.clothing.getResistance());
            System.out.println(getName() + " does " + dmg + " damage. " + selectedCharacter.getName() + " has " + selectedCharacter.getHp() + " HP left.");

        }catch (NullPointerException exception){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");
        }
    }

    public abstract IItemManager createWeapon(ArrayList<IItemManager> allWeapons);


    public void listInventory(){
        System.out.println("Inventory: ");
        for (IItemManager item:getInventory()){
            System.out.println(item.getName());
        }
        System.out.println("********************");
    }






}
