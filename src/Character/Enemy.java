package Character;


import Item.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import Main.Level;


public class Enemy extends Character {

    private Weapon weaponSelector;




    public Enemy(ArrayList<IItemManager> allItems){
        SecureRandom secureRandom = new SecureRandom();

        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+1);


        int randomNum = secureRandom.nextInt(10)+1;

        if (randomNum<=8){
            weaponSelector = new Sword();
        }else if ((randomNum==9)){
            weaponSelector = new Wand();
        }else{
            weaponSelector = new Shield();
        }

        setWeapon(createWeapon(allItems));
        setHp(calculateHp());
    }

    // TODO: 13.05.2022 add the number of items
    public Level drop(Level level){

        SecureRandom secureRandom = new SecureRandom();
        IItemManager selectedItem = level.getAllItems().get(secureRandom.nextInt());
        ArrayList<IItemManager> tempInv = level.getAllItems();
        tempInv.remove(selectedItem);

        level.setAllItems(tempInv);
        tempInv = level.getGround();
        tempInv.add(selectedItem);
        level.setGround(tempInv);
        System.out.println(getName()+" has dropped "+selectedItem.getName());

        return level;




    }

    @Override
    public void attack(Character selectedCharacter) {
        if (getWeapon()==null){
            System.out.println("This Character doesn't wield a weapon it cannot attack.");

        }else {
            int dmg = getWeapon().getAttackDmg()*(getStrength()+getVitality()+getIntelligence())/3;
            selectedCharacter.setHp(selectedCharacter.getHp() - (long) dmg);
            System.out.println(getName()+" does "+ dmg+" damage. "+selectedCharacter.getName()+" has "+selectedCharacter.getHp()+" HP left.");
        }
    }

    @Override
    public Weapon createWeapon(ArrayList<IItemManager> allItems) {
        SecureRandom secureRandom = new SecureRandom();

        Weapon selectedItem = null;
        while (selectedItem == null) {
            int randomNum = secureRandom.nextInt(allItems.size());
            for (IItemManager item : allItems) {
                if (allItems.indexOf(item) == randomNum&& item.getClass().equals(weaponSelector.getClass()) ) {
                    selectedItem = (Weapon) item;
                }

            }
        }
        return selectedItem;
    }



}
