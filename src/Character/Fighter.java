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
        System.out.println("Fighter created with S:" + getStrength() + " V: " + getVitality() + " I: " + getIntelligence() + " The HP is: " + getHp() + " Fighter wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }


    @Override
    public void attack(Character selectedCharacter) {
        if (getWeapon()==null){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*getStrength();
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }










}
