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
    public boolean turnPassed() {
        return false;
    }

    @Override
    public void specialAttack(ArrayList<Character>characters){
        Character selectedCharacter = characters.get(0);
        Character selectedTarget = characters.get(1);
        long finalHealth = selectedTarget.getHp()+(long) selectedCharacter.getIntelligence()*getAttackDmg();
        if (finalHealth>selectedTarget.calculateHp()) {
            selectedTarget.setHp(selectedTarget.calculateHp());
            System.out.println(selectedTarget.getName()+ " is healed by "+ selectedCharacter.getIntelligence()+". "+ selectedTarget.getName()+ "'s hp is now "+ selectedTarget.getHp()+".");
        }else {
            selectedTarget.setHp(finalHealth);
            System.out.println(selectedTarget.getName()+ " is healed by "+ selectedCharacter.getIntelligence()+". "+ selectedTarget.getName()+ "'s hp is now "+ selectedTarget.getHp()+".");
        }

        selectedCharacter.setSpecialAttackUsed(true);

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
    @Override
    public void display() {
        super.display();
        System.out.println(getName()+ " is a "+getClass().getName()+".");
    }
}
