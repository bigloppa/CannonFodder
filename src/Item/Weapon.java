package Item;

import  Character.Character;
public abstract class Weapon extends ItemFields implements Item  {

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
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(getName() + " has"+ attackDmg+" damage and "+getWeight()+ " units of weight.");
    }

    public abstract void specialAttack(Character selectedTarget, Character selectedCharacter);
    public abstract int calculateDmg(Character selectedCharacter);



}
