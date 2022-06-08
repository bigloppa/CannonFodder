import java.security.SecureRandom;
import java.util.ArrayList;

public class Sword extends Weapon implements CanSpecialAttack {


    public Sword(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
    }

    public Sword() {


    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getStrength();
    }

    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {

    }


    @Override
    public Item generateItem(ArrayList<Item> items) {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            int randomNum = secureRandom.nextInt(items.size());
            for (int i = 0; i < items.size(); i++) {
                if (i == randomNum && items.get(i) instanceof Sword) {
                    return items.get(i);
                }
            }
        }
    }
}
