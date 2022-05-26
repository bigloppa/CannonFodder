package Character;

import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;


public class Tank extends Character {

    public Tank(ArrayList<Item> generalInv){
        SecureRandom secureRandom = new SecureRandom();
        setName("Tank");
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+6);
        setIntelligence(secureRandom.nextInt(5)+3);
        setHp(calculateHp());
        setInventory(new ArrayList<Item>());
    }




    public Tank(){
    SecureRandom secureRandom = new SecureRandom();
    setName("Tank");
    setStrength(secureRandom.nextInt(5)+1);
    setVitality(secureRandom.nextInt(5)+6);
    setIntelligence(secureRandom.nextInt(5)+3);
    setHp(calculateHp());
    setInventory(new ArrayList<Item>());
    }
    public Tank(Weapon weapon, Clothing clothing, ArrayList<Item> inventory){
        super(weapon, clothing, inventory);
        SecureRandom secureRandom = new SecureRandom();
        setName("Tank");
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+6);
        setIntelligence(secureRandom.nextInt(5)+3);
        setHp(calculateHp());
        System.out.println("Tank created with S: " + getStrength() + " V: " + getVitality() + " I: " + getIntelligence() + " The HP is: " + getHp() + " Tank wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );

    }
}
