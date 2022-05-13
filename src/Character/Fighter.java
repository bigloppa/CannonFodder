package Character;

import Item.Item;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Character {



    public Fighter(){
        setName("Character.Fighter");
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(5)+1);
        setHp(calculateHp());
        setInventory(new ArrayList<Item>());
    }



}
