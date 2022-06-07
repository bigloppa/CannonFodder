package Character;

import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;


public class Tank extends Character {

    public Tank(ArrayList<IItemManager> allItems){
        SecureRandom secureRandom = new SecureRandom();
        setName("Tank");
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+6);
        setIntelligence(secureRandom.nextInt(5)+3);
        setHp(calculateHp());
        setWeapon(createWeapon(allItems));
        System.out.println("Tank created with S: " + getStrength() + ", V: " + getVitality() + ", I: " + getIntelligence() + ", The HP is: " + getHp() + ". Tank wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }



    @Override
    public Weapon createWeapon(ArrayList<IItemManager> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (IItemManager item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Shield) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }







}
