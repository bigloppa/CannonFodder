package Item;

import Character.Character;

public class Sword extends Weapon implements WeaponOperations {



    public Sword(String name, int weight, int attackDmg) {
        super(name, weight, attackDmg);

    }

    @Override
    public int calculateDmg(Character character) {
        return getAttackDmg()*character.getStrength();
    }

    @Override
    public void specialAttack(Character selectedTarget, Character selectedCharacter) {

    }
}
