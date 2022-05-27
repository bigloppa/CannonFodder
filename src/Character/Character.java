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



    //CONSTRUCTORS + GET-SET
    public Character(){

    }
    public Character(Weapon weapon, Clothing clothing, ArrayList<Item> inventory){
        this.weapon = weapon;
        this.clothing = clothing;
        this.inventory = inventory;
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



    //METHODS

    public long calculateHp(){
        if (Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength())>35){
            return 35;
        }else{
            return  Math.round(0.7*getVitality()+0.1*getIntelligence()+0.2*getStrength());
        }
    }

    // TODO: 13.05.2022 write the max weight value
    public boolean checkWeight(Item pickedItem){
        int sum = pickedItem.getWeight();
        for (Item item:getInventory()){
            sum += item.getWeight();

        }

        if (sum<=getVitality()*4){
            return true;
        }else{
            return false;
        }
    }

    public void pick(String[] userInput, ArrayList<Weapon> groundInventory){
        Weapon selectedItem = null;
        for (Weapon item:groundInventory){
            if (item.getName().equals(userInput[2])){
                selectedItem = item;
            }
        }

        if (selectedItem != null&&checkWeight(selectedItem)){
            groundInventory.remove(selectedItem);
            ArrayList<Item> tempInv = getInventory();
            tempInv.add(selectedItem);
            setInventory(tempInv);
            System.out.println(getName()+" has picked up the "+selectedItem.getName());

        }else{
            System.out.println("Item not found or "+getName()+" doesn't have enough strength to carry." +
                    "");
        }


    }

    public void wield(){






    }

    public void wear(String[] userInput){
        Item tempItem = null;
        ArrayList<Item> tempInv = getInventory();
        for (Item item:getInventory()){
            if (userInput[2].equals(item.getName())&&(item.getClass().equals(MedArmor.class)||item.getClass().equals(LightArmor.class)||item.getClass().equals(HardArmor.class))){
                tempItem = item;
                setClothing((Clothing) tempItem);

            }else{
                System.out.println("Item not found.");
            }

        }

        tempInv.remove(tempItem);
        setInventory(tempInv);


    }

    public void examine(String name, ArrayList<Item> ground){
        for (Item item: inventory){
            if (item.getName().equals(name)&& (item.getClass().equals(Wand.class)||item.getClass().equals(Sword.class)||item.getClass().equals(Shield.class))){
                System.out.println(item.getName()+" has "+((Weapon) item).getAttackDmg()+" and "+item.getWeight()+" unit of weight.");
            }else if (item.getName().equals(name)&& item.getClass().equals((Clothing.class))){
                System.out.println(item.getName()+ " has "+((Clothing) item).getResistance()+" and "+item.getWeight()+" unit of weight.");
            }
        }

        for (Item item: ground){
            if (item.getName().equals(name)&& (item.getClass().equals(Wand.class)||item.getClass().equals(Sword.class)||item.getClass().equals(Shield.class))){
                System.out.println(item.getName()+" has "+((Weapon) item).getAttackDmg()+" and "+item.getWeight()+" unit of weight.");
            }else if (item.getName().equals(name)&& item.getClass().equals((Clothing.class))){
                System.out.println(item.getName()+ " has "+((Clothing) item).getResistance()+" and "+item.getWeight()+" unit of weight.");
            }
        }

    }

    public abstract void attack(Character selectedCharacter);
    public abstract Item createWeapon(ArrayList<Item> allWeapons);






    public void listInventory(){
        System.out.println("Inventory: ");
        for (Item item:getInventory()){
            System.out.println(item.getName());
        }
        System.out.println("********************");
    }






}
