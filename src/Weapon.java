

public class Weapon extends Item{
    private int attackDmg;


    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    @Override
    public void examine(){
        System.out.println("Item Name: "+getName());
        System.out.println("Item Type: "+getClass());
        System.out.println("Item Weight: "+getWeight());
        System.out.println("Item Tier: "+ getTier());
        System.out.println("Item Damage"+getAttackDmg());
    }
}
