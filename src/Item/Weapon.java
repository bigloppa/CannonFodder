package Item;

import  Character.Character;
public interface Weapon extends ItemFields implements Item  {



    public abstract void specialAttack(Character selectedTarget,Character selectedCharacter);
    public abstract int calculateDmg(Character selectedCharacter);





}
