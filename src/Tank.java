import java.security.SecureRandom;
import java.util.ArrayList;


public class Tank extends Character {

    public Tank(ArrayList<Item> allItems){
        SecureRandom secureRandom = new SecureRandom();
        setName("Tank");
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+6);
        setIntelligence(secureRandom.nextInt(5)+3);
        setHp(calculateHp());
        setWeapon(createWeapon(allItems));
        System.out.print("Tank created with S: " + getStrength() + ", V: " + getVitality() + ", I: " + getIntelligence() + ", The HP is: " + getHp() + ". Tank wields " );
        getWeapon().display();
    }



    @Override
    public Weapon createWeapon(ArrayList<Item> allItems) {
        SecureRandom secureRandom = new SecureRandom();
        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (Item item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item instanceof Shield) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;


    }







}
