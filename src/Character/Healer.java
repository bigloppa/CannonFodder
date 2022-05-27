package Character;



import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Healer extends Character {



    public Healer(ArrayList<Item> allItems){
        setName("Healer");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+3);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+6);
        setHp(calculateHp());
        setWeapon(createWeapon(allItems));
        setInventory(new ArrayList<Item>());
        System.out.println("Healer created with S: " + getStrength() + " V: " + getVitality() + " I: " + getIntelligence() + " The HP is: " + getHp() + " Healer wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }










    @Override
    public void attack(Character selectedCharacter) {
        if (getWeapon()==null){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*getIntelligence();
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }

    @Override
    public Weapon createWeapon(ArrayList<Item> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (Item item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Wand) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }


}
