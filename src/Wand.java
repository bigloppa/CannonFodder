import java.security.SecureRandom;
import java.util.ArrayList;

public class Wand extends Weapon implements CanSpecialAttack {

    public Wand(){

    }

    public Wand(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
    }

    @Override
    public void specialAttack(Character selectedTarget,Character selectedCharacter){
        long finalHealth = selectedTarget.getHp()+(long) selectedCharacter.getIntelligence();
        if (finalHealth>35&& selectedCharacter.getState() == 2) {
            selectedTarget.setHp(35);
        }else if (selectedCharacter.getHp()>=0){
            selectedCharacter.setHp(finalHealth);
        }else{
            System.out.println("A dead character cannot be healed.");
        }

    }




    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getIntelligence();
    }

    @Override
    public Item generateItem(ArrayList<Item> items) {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            int randomNum = secureRandom.nextInt(items.size());
            for (int i = 0; i < items.size(); i++) {
                if (i == randomNum && items.get(i) instanceof Wand) {
                    return items.get(i);
                }
            }
        }
    }
}
