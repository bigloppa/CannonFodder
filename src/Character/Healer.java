package Character;



import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Healer extends Character {



    public Healer(ArrayList<IItemManager> allItems){
        setName("Healer");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+3);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+6);
        setHp(calculateHp());
        setWeapon(createWeapon(allItems));
        System.out.println("Healer created with S: " + getStrength() + ", V: " + getVitality() + ", I: " + getIntelligence() + ", The HP is: " + getHp() + ". Healer wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }



    @Override
    public Weapon createWeapon(ArrayList<IItemManager> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (IItemManager item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Wand) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }


}
