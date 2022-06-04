package Item;

import Character.Character;

public class Sword extends Weapon {



    public Sword() {


    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getStrength();
    }

    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {

    }
}
