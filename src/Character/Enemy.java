package Character;


import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import Main.Level;


public class Enemy extends Character {

    public Enemy(){
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+1);
    }

    // TODO: 13.05.2022 add the number of items
    public Level drop(Level level){

        SecureRandom secureRandom = new SecureRandom();
        Item selectedItem = level.getGeneralInv().get(secureRandom.nextInt());
        ArrayList<Item> tempInv = level.getGeneralInv();
        tempInv.remove(selectedItem);

        level.setGeneralInv(tempInv);
        tempInv = level.getGround();
        tempInv.add(selectedItem);
        level.setGround(tempInv);
        System.out.println(getName()+" has dropped "+selectedItem.getName());

        return level;




    }

    @Override
    public void attack(Character selectedCharacter) {
        if (getWeapon()==null){
            System.out.println("This Character.Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*(getStrength()+getVitality()+getIntelligence())/3;
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }


}
