package Item;

import Character.Character;

public class Sword extends Weapon {


    public Sword(){

    }
    public Sword(String name, int weight, int attackDmg) {
        super(name, weight, attackDmg);

    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getStrength();
    }
}
