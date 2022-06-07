import java.security.SecureRandom;
import java.util.ArrayList;

public abstract class Weapon extends ItemFields implements IWeaponManager,Item {

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
        System.out.println(getName() + " has "+ attackDmg+" damage and "+getWeight()+ " units of weight.");
    }

    public abstract void specialAttack(Character selectedTarget, Character selectedCharacter);


    @Override
    public  Item findItem(String name, ArrayList<Item> items) {
        Item selectedItem = null;
        for (Item item: items){
            if (this.name.equals(name)){
                selectedItem = item;
            }
        }

        return selectedItem;

    }
}
