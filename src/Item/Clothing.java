package Item;



public class Clothing extends ItemFields implements IItemManager {
    private int resistance;

    public Clothing(){

    }

    public Clothing(int resistance) {
        this.resistance = resistance;
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


    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }


    @Override
    public void display() {
        System.out.println(getName() + " has"+ getResistance()+" resistance, and "+getWeight()+ " units of weight.");
    }


}
