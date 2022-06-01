package Item;


public  class Weapon implements Item {
    private int attackDmg;
    String name;





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
