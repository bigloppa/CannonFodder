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
    private String surname;
    private ArrayList<Item> inventory;



    //CONSTRUCTORS + GET-SET
    public Character(){

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void attack(Character selectedCharacter){
        if (getWeapon()==null){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*getStrength();
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }



    }

    public void pick(){


    }

    public void wield(String[] userInput){
        Item tempItem = null;
        ArrayList<Item> tempInv = getInventory();
        for (Item item:getInventory()){
            if (userInput[2].equals(item.getName())&&(item.getClass().equals(Shield.class)||item.getClass().equals(Sword.class)||item.getClass().equals(Wand.class))){
                tempItem = item;
                setWeapon((Weapon) tempItem);

            }else{
                System.out.println("Item not found.");
            }
        }

        tempInv.remove(tempItem);
        setInventory(tempInv);

    }

    public void wear(){


    }



    public void listInventory(){
        System.out.println("Inventory: ");
        for (Item item:getInventory()){
            System.out.println(item.getName());
        }
        System.out.println("********************");
    }

    public void death(){

    }






}
