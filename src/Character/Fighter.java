package Character;

import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Character {




    public Fighter(ArrayList<IItemManager> allItems){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setWeapon(createWeapon(allItems));
        setHp(calculateHp());
        System.out.println("Fighter created with S: " + getStrength() + ", V: " + getVitality() + ", I: " + getIntelligence() + ", The HP is: " + getHp() + ". Fighter wields " + getWeapon().getName() + " with " + getWeapon().getAttackDmg() + " damage and " + getWeapon().getWeight() + " unit of weight." );
    }

    public Fighter(){
        setName("Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setInventory(new ArrayList<IItemManager>());
    }



    @Override
    public Weapon createWeapon(ArrayList<IItemManager> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (IItemManager item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Sword) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }


}
