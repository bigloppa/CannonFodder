package Item;

import  Character.Character;
public abstract class Weapon extends ItemFields implements IWeaponManager {

    private int attackDmg;


    public Weapon(){

    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }


    @Override
    public void display() {
        System.out.println(getName() + " has"+ attackDmg+" damage and "+getWeight()+ " units of weight.");
    }

    public abstract void specialAttack(Character selectedTarget, Character selectedCharacter);
    public abstract int calculateDmg(Character selectedCharacter);



}
