public class Shield extends Weapon {


   private int harm;  //character(damage * vitality)

    public Shield() {

    }

    public Shield(String name, int value, int weight, int attackDmg, int harm) {
        super(name, value, weight, attackDmg);
        this.harm = harm;
    }

    public void stun(){

    }
}
