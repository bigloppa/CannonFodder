import java.security.SecureRandom;
import java.util.ArrayList;

public class Shield extends Weapon{

     private int leftChancesToStun;

    public Shield(){

    }

    public Shield(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
    }


    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getVitality();
    }




    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {
        if (leftChancesToStun>0){
            selectedTarget.setState(1);
        }else {
            System.out.println("This character cannot stun anymore.");
        }
        leftChancesToStun--;
    }

    @Override
    public Item generateItem(ArrayList<Item> items) {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            int randomNum = secureRandom.nextInt(items.size());
            for (int i = 0; i < items.size(); i++) {
                if (i == randomNum && items.get(i) instanceof Shield) {
                    return items.get(i);
                }
            }
        }
    }



}
