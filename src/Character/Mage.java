package Character;



import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Mage extends Character {


    public Mage(){
        setName("Healer");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+3);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+6);
        setHp(calculateHp());
        setInventory(new ArrayList<Item>());
    }
    public Mage(Weapon weapon, Clothing clothing, ArrayList<Item> inventory){
        super(weapon, clothing, inventory);
        setName("Healer");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+3);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+6);
        setHp(calculateHp());
        System.out.println("Healer created with S: " + getStrength() + " V: " + getVitality() + " I: " + getIntelligence() + " The HP is: " + getHp() + " Healer wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );


    }
}
