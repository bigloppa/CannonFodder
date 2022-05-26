package Character;

import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Character {




    public Fighter(ArrayList<Item> generalInv){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setWeapon(selectRandomItem(generalInv));
        setInventory(new ArrayList<Item>());
    }
    public Fighter(){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setInventory(new ArrayList<Item>());
    }
    public Fighter(Weapon weapon,Clothing clothing,ArrayList<Item> inventory){
        super(weapon, clothing, inventory);
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setWeapon(selectRandomItem(inventory));
        System.out.println("Fighter created with S:" + getStrength() + " V: " + getVitality() + " I: " + getIntelligence() + " The HP is: " + getHp() + " Fighter wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }






    public Sword selectRandomItem(ArrayList<Item>generalInv){
        SecureRandom secureRandom = new SecureRandom();
        Sword selectedItem = null;

        while(selectedItem == null) {
            int randomNum = secureRandom.nextInt(generalInv.size());
            for (Item item : generalInv) {
                if(randomNum == generalInv.indexOf(item)&& item.getClass().equals(Sword.class)){
                    selectedItem = (Sword)item;
                }

            }
        }
        return selectedItem;


    }



}
