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
    public Mage(ArrayList<Item> GeneralInv){
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

    @Override
    public void attack(Character selectedCharacter) {
        if (getWeapon()==null){
            System.out.println("This Character.Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*getIntelligence();
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }

    @Override
    public Weapon selectRandomItem(ArrayList<Item>generalInv){
        SecureRandom secureRandom = new SecureRandom();
        Wand selectedItem = null;

        while(selectedItem == null) {
            int randomNum = secureRandom.nextInt(generalInv.size());
            for (Item item : generalInv) {
                if(randomNum == generalInv.indexOf(item)&& item.getClass().equals(Wand.class)){
                    selectedItem = (Wand)item;
                }

            }
        }
        return selectedItem;


    }


}
