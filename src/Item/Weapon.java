package Item;

import Character.Character;


public  class Weapon extends Item implements ItemOperations {
    private int attackDmg;

    public Weapon(String name, int weight, int attackDmg) {
        setName(name);
        setWeight(weight);
        this.attackDmg = attackDmg;
    }


    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    @Override
    public void display() {
        System.out.println(getName()+ " has "+ getAttackDmg()+ " damage, and "+ getWeight()+" units of weight.");
    }



}
