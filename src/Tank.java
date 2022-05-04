import java.security.SecureRandom;
import java.util.ArrayList;

public class Tank extends Character{



    public void wield(String[] userInput) {
        ArrayList<Item> tempInventory = getInventory();
        Item selectedItem = null;
        for (Item item:getInventory()){
           if (userInput[2].equals(item.getName())&&item.getClass().equals(Shield.class)){

               setWeapon((Weapon) item);
               selectedItem = item;
               System.out.println(getName()+" is now wielding "+item.getName());
           }

        }
        tempInventory.remove(selectedItem);
        setInventory(tempInventory);
    }




    public Tank(){
    SecureRandom secureRandom = new SecureRandom();
    setStrength(secureRandom.nextInt(5)+1);
    setVitality(secureRandom.nextInt(5)+6);
    setIntelligence(secureRandom.nextInt(5)+3);
    calculateHp();


    }
}
