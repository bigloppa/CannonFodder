package Character;



import Item.Item;

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
}
