package Item;



public class Weapon extends Item {
    private int attackDmg;

    public Weapon(){

    }

    public Weapon(String name, int value, int weight, int attackDmg) {
        super(name, value, weight);
        this.attackDmg = attackDmg;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    @Override
    public void examine(){
        System.out.println("Item.Item Name: "+getName());
        System.out.println("Item.Item Type: "+getClass());
        System.out.println("Item.Item Weight: "+getWeight());
        System.out.println("Item.Item Tier: "+ getTier());
        System.out.println("Item.Item Damage"+getAttackDmg());
    }
}
