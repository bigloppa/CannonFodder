import java.security.SecureRandom;
import java.util.ArrayList;

public class Sword extends Weapon implements CanSpecialAttack {

    private int turnsForParry;





    public Sword(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        setAttackDmg(attackDmg);
        turnsForParry = 4;
    }

    public Sword() {


    }

    public int getTurnsForParry() {
        return turnsForParry;
    }

    public void setTurnsForParry(int turnsForParry) {
        this.turnsForParry = turnsForParry;
    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getStrength();
    }

    @Override
    public void specialAttack(ArrayList<Character> characters) {
        characters.get(0).setState(0);
        turnsForParry--;
    }

    @Override
    public boolean turnPassed(){
        if (turnsForParry<4&&turnsForParry>0){
            turnsForParry--;
            return false;
        }else{

            return true;

        }
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
