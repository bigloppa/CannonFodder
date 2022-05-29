package Item;

import Character.Character;

public interface WeaponOperations {
    public void specialAttack(Character selectedTarget, Character selectedCharacter);
    public int calculateDmg(Character character);

}
