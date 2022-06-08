import java.security.SecureRandom;
import java.util.ArrayList;

public class Shield extends Weapon{

     private int turnsForStun;

    public Shield(){
        turnsForStun = 3;
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
    public boolean turnPassed() {
        if (turnsForStun<3&&turnsForStun>0){
            turnsForStun--;
            return false;
        }else{
            turnsForStun = 3;
            return true;

        }
    }


    @Override
    public void specialAttack(ArrayList<Character> characters) {

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
