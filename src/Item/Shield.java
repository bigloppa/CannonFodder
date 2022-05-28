package Item;

import Character.Character;


public class Shield extends Weapon {




    public Shield() {


    }

    public Shield(String name, int weight, int attackDmg) {
        super(name, weight, attackDmg);

    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getVitality();
    }
}
